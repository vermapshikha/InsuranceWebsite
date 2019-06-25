package controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Mail;
import dao.passwordDao;
import vo.loginVo;

/**
 * Servlet implementation class managePassword
 */
@WebServlet("/managePassword")
public class managePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("Submit"))
		{
			submit(request,response);
		}
		else if(flag.equals("Change"))
		{
			change(request,response);
		}
			
			}

	private void submit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		String email=request.getParameter("userEmail");
		loginVo lvo=new loginVo();
		lvo.setUserName(email);
		passwordDao pdo= new passwordDao();
		List list=pdo.search(lvo);
	
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String otp = sb.toString();
		
		System.out.println("Bhai Otp : " + otp);
		
	
		if(list != null && list.size()>=1)
		{
			Mail mail = new Mail();
			mail.sendMail(email,"Change Your Password", "Your Otp is : " + otp,"vpshina1227@gmail.com","computer123");
		loginVo user=(loginVo) list.get(0);
		h.setAttribute("list", list);
		int y = user.getLogin_ID();
		System.out.println(y);
		h.setAttribute("ID",y);
		h.setAttribute("generatedOTP",otp);
		
		response.sendRedirect("Agent/forgot2.jsp");

		
		}
	else 
	{
		response.sendRedirect("agent/login.jsp");
	}
	}
	
	

private void change(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	HttpSession h= request.getSession();
	String otp=request.getParameter("userOTP");
	String password=  request.getParameter("password");
	String cpassword= request.getParameter("cpassword");
	int id=(int)h.getAttribute("ID");
	
	if (cpassword.equals(password))
	{
		loginVo lvo= new loginVo();
		lvo.setLogin_ID(id);
		lvo.setPassWord(password);
		
		passwordDao pdo= new passwordDao();
		pdo.update(lvo);
	}

}
}
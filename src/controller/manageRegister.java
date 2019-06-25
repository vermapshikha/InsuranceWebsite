

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.loginDao;
import dao.registerDao;


import vo.loginVo;
import vo.registerVO;

/**
 * Servlet implementation class manageRegister
 */
@WebServlet("/manageRegister")
public class manageRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("Search");
		{
			search(request,response);
			
		}
				

	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("Register"))
		{
			register(request,response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstName");
		String lastname=request.getParameter("lastName");
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		String type=request.getParameter("userType");
				
	    //HttpSession h= request.getSession();
		
		
		registerVO rvo=new registerVO();
		rvo.setFirstname(firstname);
        rvo.setLastname(lastname);
        
		loginVo lvo=new loginVo();
		lvo.setUserName(username);
		lvo.setPassWord(password);
		lvo.setUser_type(type);
		
		//LoginVo is the parent cz the object is sent in the RegVo so thus parent Dao will be first
		
		loginDao ld=new loginDao();
		ld.insert(lvo);
		rvo.setL(lvo);
		
		registerDao rd=new registerDao();
		rd.insert(rvo);
		//h.setAttribute("fn", f);
		//h.setAttribute("ln", l);
		
		
		response.sendRedirect("Agent/login.jsp");

		
	}

}

package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.feedbackDao;
import vo.feedbackVo;
import vo.loginVo;

/**
 * Servlet implementation class manageFeedback
 */
@WebServlet("/manageFeedback")
public class manageFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f1=request.getParameter("flag1");
		if(f1.equals("delete")){
			delete(request,response);
			search2(request,response);
		}
		
		else if (f1.equals("Search")){
			 search2(request,response);
	}
	}
	
	
	

	private void search2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();

		feedbackDao fdo= new feedbackDao();
         List<feedbackVo> ls=fdo.search();
         h.setAttribute("list",ls);
         response.sendRedirect("admin/ManageFeedback.jsp");

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		feedbackVo fvo= new feedbackVo();
		fvo.setFeedback_ID(i1);
		feedbackDao fdo=new feedbackDao();
		List ls=fdo.delete(fvo);
		h.setAttribute("list", ls);
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String f=request.getParameter("flag");
		System.out.println("--->>"+f);
		 if (f.equals("Submit")){
			 save(request,response);

		 }
		
	}

	
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String description=request.getParameter("feedback");
		int loginid = (int) h.getAttribute("userID");
	
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	    String date = dateFormat.format(d);
	    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

	     String time = timeFormat.format(d);
		 loginVo lvo = new loginVo();
		 lvo.setLogin_ID(loginid);
	 
	   feedbackVo fvo =new feedbackVo();
	   fvo.setUserName(name);
	   fvo.setUserEmail(email);
	   fvo.setFeedbackSubject(subject);
	   fvo.setFeedbackDes(description);
	   fvo.setFeedbackFrom(lvo);
	   fvo.setFeedbackDate(date);
       fvo.setFeedbackTime(time);
       fvo.setFeedbackStatus("Active");
	  
	   
	   feedbackDao fdo= new feedbackDao();
	    fdo.insert(fvo);
	    response.sendRedirect("user/thanks.jsp");
		}



}

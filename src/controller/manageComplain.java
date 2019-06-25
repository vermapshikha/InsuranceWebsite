package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.complainDao;
import vo.complainVo;
import vo.loginVo;

/**
 * Servlet implementation class manageComplain
 */
@WebServlet("/manageComplain")
public class manageComplain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageComplain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String flag = request.getParameter("flag");
		System.out.println("COMPLAIN:" + flag);

		if (flag.equals("searchcomplain")) 
		{
			searchcomplain(request, response);
		} 
		else if (flag.equals("replyComplain"))
		{
			replyComplain(request, response);
		} 
		else if(flag.equals("viewComplain"))
		{
			viewComplain(request,response);
		}

	}

	private void viewComplain(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		int id = (int) request.getSession().getAttribute("userID");
		
		loginVo complainTo = new loginVo();
		complainTo.setLogin_ID(id);
		
		complainVo vo = new complainVo();
		vo.setComplainTo(complainTo);
		
		complainDao complainDao = new complainDao();
		List complainList = complainDao.searchReply(vo);

		System.out.println("List SIZE>>>>>>>>" + complainList.size());
		session.setAttribute("usercomplainList", complainList);
		System.out.println("***COMPLAIN LIST***" + complainList.size());
		response.sendRedirect("user/viewComplain.jsp");
	
	}

	private void replyComplain(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		int i1 = Integer.parseInt(request.getParameter("id"));

		complainVo cvo = new complainVo();
		cvo.setComplainID(i1);

		complainDao cdo = new complainDao();
		ls = cdo.replyComplain(cvo);

		HttpSession session = request.getSession();
		session.setAttribute("List", ls);
		System.out.println("hi");
		response.sendRedirect("admin/replyComplain.jsp");
	}


	private void searchcomplain(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		complainDao complainDao = new complainDao();
		List complainList = complainDao.search();

		System.out.println("List SIZE>>>>>>>>" + complainList.size());
		session.setAttribute("usercomplainList", complainList);
		System.out.println("***COMPLAIN LIST***" + complainList.size());
		response.sendRedirect("admin/ManageComplain.jsp");

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		
		System.out.println("COMPLAIN>>>" + flag);
		
		if (flag.equals("submit")) 
		{
			complain(request, response);
			
		}
		else if (flag.equals("replyInsert"))
		{

			reply(request, response);

		}

	}

	private void reply(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int complainToId =Integer.parseInt(request.getParameter("ComplainTo")); 
		int complainFromId =Integer.parseInt(request.getParameter("ComplainFrom")); 
		
	    loginVo complainTo = new loginVo();
		complainTo.setLogin_ID(complainToId);
		
		loginVo complainFrom = new loginVo();
		complainFrom.setLogin_ID(complainFromId);
		
		
		int complainId = Integer.parseInt(request.getParameter("Complainid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("Complainsubject");
		String description = request.getParameter("complainDes");
		String ReplyDescription = request.getParameter("replyDes");
		

		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		String date = dateFormat.format(d);
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		String time = timeFormat.format(d);

		System.out.println(time);


		complainVo cvo = new complainVo();
		cvo.setComplainID(complainId);
		cvo.setComplainName(name);
		cvo.setComplainEmail(email);
		cvo.setComplainSubject(subject);
		cvo.setComplainDes(description);
		cvo.setComplainreplyDescription(ReplyDescription);
		cvo.setComplainDate(date);
		cvo.setComplainTime(time);
		cvo.setComplainFrom(complainFrom);
		cvo.setComplainTo(complainTo);
		cvo.setComplainStatus("Replied");

		complainDao cdo = new complainDao();
		cdo.replyInsert(cvo);

		searchcomplain(request, response);
		

	}

	private void complain(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = (int) request.getSession().getAttribute("userID");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String description = request.getParameter("Description");
		String replydescription = request.getParameter("replyDescription");
		
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		String date = dateFormat.format(d);
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		String time = timeFormat.format(d);

		System.out.println(time);

		loginVo complainFrom = new loginVo();
		complainFrom.setLogin_ID(id);

		complainDao cdo = new complainDao();

		
		  List ls = cdo.searchAdmin();
		  
		  System.out.println("List Size>>>>>>"+ls.size());
		  
		  loginVo complainTo = (loginVo)ls.get(0);
		 

		complainVo cvo = new complainVo();

		cvo.setComplainName(name);
		cvo.setComplainEmail(email);
		cvo.setComplainSubject(subject);
		cvo.setComplainDes(description);
		cvo.setComplainreplyDescription(replydescription);
		cvo.setComplainDate(date);
		cvo.setComplainTime(time);
		cvo.setComplainFrom(complainFrom);
		cvo.setComplainTo(complainTo);
		cvo.setComplainStatus("Pending");

		complainDao complainDAO = new complainDao();
		complainDAO.insert(cvo);

		response.sendRedirect("user/thanks.jsp");
	}

	}



package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.agentDao;
import vo.clientVo;

/**
 * Servlet implementation class manageClient
 */
@WebServlet("/manageClient")
public class manageClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public manageClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String f1 = request.getParameter("flag1");
		if (f1.equals("delete"))
		{
		  delete(request, response);
		  search(request, response);
		}
		else if (f1.equals("edit"))
			{
			edit(request, response);
			}
		else if (f1.equals("Search"))
		{
		
			search(request, response);
	}
		}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i1 = Integer.parseInt(request.getParameter("id"));
		HttpSession h = request.getSession();
		clientVo cvo = new clientVo();
		cvo.setId(i1);
		agentDao ado = new agentDao();
		List ls = new ArrayList();
		ls = ado.edit(cvo);
		h.setAttribute("list", ls);
		response.sendRedirect("Agent/editClient.jsp");

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession h = request.getSession();
		int i1 = Integer.parseInt(request.getParameter("id"));
		clientVo cvo = new clientVo();
		cvo.setId(i1);
		agentDao ado = new agentDao();
		List ls = ado.delete(cvo);
		h.setAttribute("list", ls);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String f = request.getParameter("flag");
		if (f.equals("Submit")) {
			save(request, response);
		} else if (f.equals("Update")) {
			update(request, response);
			search(request, response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h = request.getSession();

		agentDao ado = new agentDao();
		List<clientVo> ls = null;
		ls = ado.search();
		h.setAttribute("list", ls);
		response.sendRedirect("Agent/viewClient.jsp");

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id1 = Integer.parseInt(request.getParameter("Clientid"));
		String cid = request.getParameter("clientID");
		String cn = request.getParameter("clientName");
		String age = request.getParameter("clientAge");
		String ca1 = request.getParameter("clientAddress1");
		String ca2 = request.getParameter("clientAddress2");
		String state = request.getParameter("clientState");
		String country = request.getParameter("clientCountry");
		String city = request.getParameter("clientCity");
		String telephone = request.getParameter("telephone");

		String dob = request.getParameter("DOB");
		String employed = request.getParameter("employed");
		String email = request.getParameter("email");

		clientVo cvo = new clientVo();
		cvo.setId(id1);
		cvo.setClientName(cn);
		cvo.setClientTelephone(telephone);
		cvo.setClientAge(age);
		cvo.setClientAddress1(ca1);
		cvo.setClientAddress2(ca2);
		cvo.setClientCity(city);
		cvo.setClientCountry(country);
		cvo.setClientDOB(dob);
		cvo.setClientEmailid(email);
		cvo.setClientID(cid);
		cvo.setClientState(state);
		cvo.setClientEmployment(employed);

		agentDao ado = new agentDao();
		ado.update(cvo);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String cid = request.getParameter("clientID");
		String cn = request.getParameter("clientName");
		String age = request.getParameter("clientAge");
		String ca1 = request.getParameter("clientAddress1");
		String ca2 = request.getParameter("clientAddress2");
		String state = request.getParameter("clientState");
		String country = request.getParameter("clientCountry");
		String city = request.getParameter("clientCity");
		String telephone = request.getParameter("telephone");

		String dob = request.getParameter("DOB");
		String employed = request.getParameter("employed");
		String email = request.getParameter("email");
 
		System.out.println("ID:" + cid);
		
		clientVo cvo = new clientVo();
		// cvo.setID(i4);
		cvo.setClientName(cn);
		cvo.setClientTelephone(telephone);
		cvo.setClientAge(age);
		cvo.setClientAddress1(ca1);
		cvo.setClientAddress2(ca2);
		cvo.setClientCity(city);
		cvo.setClientCountry(country);
		cvo.setClientDOB(dob);
		cvo.setClientEmailid(email);
		cvo.setClientID(cid);
		cvo.setClientState(state);
		cvo.setClientEmployment(employed);

		agentDao ado = new agentDao();
		ado.insert(cvo);
		response.sendRedirect("Agent/insertClient.jsp");

	}
}

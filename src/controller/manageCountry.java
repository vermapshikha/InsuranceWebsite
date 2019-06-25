package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.countryDao;
import vo.countryVo;

/**
 * Servlet implementation class manageCountry
 */
@WebServlet("/manageCountry")
public class manageCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageCountry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f1= request.getParameter("flag");
		if(f1.equals("edit"))
		{
			edit(request,response);
		}
		else if(f1.equals("delete"))
		{
			delete(request,response);
			search(request,response);
		}
		else if (f1.equals("Search"))
		{
			search(request,response);
		}
		
	}

	

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i1=Integer.parseInt(request.getParameter("id"));
		HttpSession h=request.getSession();
 		countryVo cvo=new countryVo();
		cvo.setCountry_ID(i1);
		countryDao ado=new countryDao();
		List ls=ado.edit(cvo);
		h.setAttribute("List", ls);
		response.sendRedirect("admin/editCountry.jsp");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i1=Integer.parseInt(request.getParameter("id"));
		countryVo cvo=new countryVo();
		cvo.setCountry_ID(i1);
		countryDao ado=new countryDao();
		ado.delete(cvo);
		
	}
	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		countryVo cvo= new countryVo();
		countryDao ado=new countryDao();
		List ls=ado.search(cvo);
		h.setAttribute("list", ls);
		response.sendRedirect("admin/viewCountry.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String flag=request.getParameter("flag");
	    if (flag.equals("Submit"))
	    {
	    	submit(request,response);
	    	search(request,response);
	    }
	    else if (flag.equals("Update"))
	    {
	    	update(request,response);
	    	search(request,response);
	    }
	    }
	
	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("countryID"));
		String Country=request.getParameter("country");
		String CountryDes=request.getParameter("countryDes");
		countryVo cvo= new countryVo();
		cvo.setCountry_ID(id);
		cvo.setCountry(Country);
		cvo.setCountryDes(CountryDes);
		cvo.setCountryStatus("Active");
		countryDao ado=new countryDao();
		ado.update(cvo);
		
	}

	private void submit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String Country=request.getParameter("country");
		String CountryDes=request.getParameter("countryDes");
		countryVo cvo= new countryVo();
		cvo.setCountry(Country);
		cvo.setCountryDes(CountryDes);
		cvo.setCountryStatus("Active");;
		countryDao ado=new countryDao();
		ado.insert(cvo);
		
	}
}



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
import vo.cityVo;
import vo.countryVo;
import vo.stateVo;

/**
 * Servlet implementation class manageCity
 */
@WebServlet("/manageCity")
public class manageCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		if (flag.equals("edit"))
		{
		  edit(request,response);
		}
		else if (flag.equals("delete"))
		{
			delete(request,response);
			search(request,response);
		}
		else if (flag.equals("loadState"))
		{
			loadState(request,response);
		}
		else if(flag.equals("search"))
		{
			search(request,response);
		}
		else if (flag.equals("load"))
		{
			load(request,response);
		}
		else if(flag.equals("loadcity"))
		{
			loadcity(request,response);
		}
	}

	private void loadcity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("stateID"));
		stateVo stvo= new stateVo();
		stvo.setState_ID(id);
		
		countryDao ado= new countryDao();
		List ls=ado.loadCity(stvo);
		
		HttpSession h= request.getSession();
		
		h.setAttribute("List", ls);
		System.out.println("LIst SIZE>>>>>>>>>>>>"+ls.size());
		
		response.sendRedirect("admin/cityAgJSON.jsp");
	
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("countryID"));
		countryVo vo = new countryVo();
		vo.setCountry_ID(id);
		
		countryDao ado= new countryDao();
		List ls=ado.loadState(vo);
		
		HttpSession h= request.getSession();
		
		h.setAttribute("List", ls);
		System.out.println("LIst SIZE>>>>>>>>>>>>"+ls.size());
		
		response.sendRedirect("admin/cityJSON.jsp");
	
	}

	private void loadState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		countryVo cvo= new countryVo();
		stateVo svo= new stateVo();
		countryDao ado= new countryDao();
		List ls= ado.search(cvo);
		h.setAttribute("list",ls);
		List list= ado.search1(svo);
		h.setAttribute("list1", list);
		response.sendRedirect("admin/insertCity.jsp");
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i1=Integer.parseInt(request.getParameter("id"));
		cityVo civo=new cityVo();
		civo.setCity_ID(i1);
		countryDao ado= new countryDao();
		ado.delete(civo);
	
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i1=Integer.parseInt(request.getParameter("id"));
		HttpSession h=request.getSession();
		cityVo civo=new cityVo();
		civo.setCity_ID(i1);
		countryDao ado= new countryDao();
		List ls=ado.edit(civo);
		h.setAttribute("List", ls);
		response.sendRedirect("admin/editCity.jsp");
		
		
	}
	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		cityVo civo= new cityVo();
		countryDao ado= new countryDao();
		List ls=ado.search3(civo);
		h.setAttribute("list", ls);
		response.sendRedirect("admin/viewCity.jsp");
	
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
			int id=Integer.parseInt(request.getParameter("cityID"));
			int country=Integer.parseInt(request.getParameter("counry"));
			int state=Integer.parseInt(request.getParameter("state"));
			String City=request.getParameter("city");
			String CityDes=request.getParameter("cityDes");
		    countryVo cvo=new countryVo();
		    cvo.setCountry_ID(country);
		    
		    stateVo svo= new stateVo();
		    svo.setState_ID(state);
		    
			cityVo civo= new cityVo();
		    civo.setCity_ID(id);
		    civo.setCity(City);
		    civo.setCityDes(CityDes);
		    civo.setCvo(cvo);
		    civo.setSvo(svo);
		  
		    countryDao ado= new countryDao();
			ado.update(civo);
			
		}

		private void submit(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			int country=Integer.parseInt(request.getParameter("country"));
			int state=Integer.parseInt(request.getParameter("state"));
			String City=request.getParameter("city");
			String CityDes=request.getParameter("cityDes");
		    countryVo cvo=new countryVo();
		    cvo.setCountry_ID(country);
		    stateVo svo= new stateVo();
		    svo.setState_ID(state);
		    
			cityVo civo= new cityVo();
  
		    civo.setCity(City);
		    civo.setCityDes(CityDes);
		    civo.setCvo(cvo);
		    civo.setSvo(svo);
		    civo.setCityStatus("Active");
		  
		    countryDao ado= new countryDao();
			ado.insert(civo);
			
		}

	}



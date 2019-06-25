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
import vo.stateVo;

/**
 * Servlet implementation class manageState
 */
@WebServlet("/manageState")
public class manageState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageState() {
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
			search1(request,response);
		}
		else if (f1.equals("Search"))
		{
			search1(request,response);
		}
		else if(f1.equals("loadCountry"))
		{
			loadCountry(request,response);
		}
	}

	

	private void loadCountry(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		countryVo cvo= new countryVo();
		countryDao ado= new countryDao();
		List ls=ado.search(cvo);
		h.setAttribute("list",ls);
		response.sendRedirect("admin/insertState.jsp");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i1=Integer.parseInt(request.getParameter("id"));
		HttpSession h=request.getSession();
		stateVo svo=new stateVo();
		svo.setState_ID(i1);
		countryDao ado= new countryDao();
		List ls=ado.edit(svo);
		h.setAttribute("List", ls);
		response.sendRedirect("admin/editState.jsp");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i1=Integer.parseInt(request.getParameter("id"));
		stateVo svo=new stateVo();
		svo.setState_ID(i1);
		countryDao ado= new countryDao();
		ado.delete(svo);
		
	}
	private void search1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		stateVo svo=new stateVo();
		countryDao ado= new countryDao();
		List ls=ado.search1(svo);
		h.setAttribute("list", ls);
		response.sendRedirect("admin/viewState.jsp");
	
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
		    	search1(request,response);
		    }
		    else if (flag.equals("Update"))
		    {
		    	update(request,response);
		    	search1(request,response);
		    }
		    }
		
		private void update(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			int id=Integer.parseInt(request.getParameter("stateID"));
			int id1=Integer.parseInt(request.getParameter("country"));
			String State=request.getParameter("state");
			String StateDes=request.getParameter("stateDes");
			countryVo cvo=new countryVo();
			cvo.setCountry_ID(id1);
			stateVo svo= new stateVo();
			svo.setState_ID(id);
			svo.setState(State);
			svo.setStateDes(StateDes);
			svo.setCvo(cvo);
			
			countryDao ado= new countryDao();
			ado.update(svo);
			
		}

		private void submit(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
		    int id= Integer.parseInt(request.getParameter("country"));
			String State=request.getParameter("state");
			String StateDes=request.getParameter("stateDes");
			countryVo cvo= new countryVo();
			cvo.setCountry_ID(id);
			stateVo svo= new stateVo();
            svo.setState(State);
			svo.setStateDes(StateDes);
			svo.setStateStatus("Active");
			svo.setCvo(cvo);
			countryDao ado= new countryDao();
			ado.insert(svo);
			
		}

	}



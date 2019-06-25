



package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegDao;
import dao.companyDao;
import vo.RegVo;
import vo.companyVo;
import vo.planVo;

/**
 * Servlet implementation class managePlan
 */
@WebServlet("/managePlan")
public class managePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managePlan() {
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
			search1(request,response);
		}
		else if (f1.equals ("loadCompany"))
		{
			loadCompany(request,response);
		}
		else if(f1.equals("edit"))
			edit(request,response);
		else if (f1.equals("Search"))
			 search1(request,response);
	}

	private void loadCompany(HttpServletRequest request, HttpServletResponse response)throws IOException {
		HttpSession h= request.getSession();
		companyDao cdo=new companyDao();
		List ls=cdo.search();
		h.setAttribute("list",ls);
		response.sendRedirect("admin/policyPlan.jsp");
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		planVo pvo= new planVo();
		pvo.setPlan_id(i1);
		companyDao cdo=new companyDao();
		List ls=cdo.edit(pvo);
		h.setAttribute("list", ls);
		response.sendRedirect("admin/editPlan.jsp");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		planVo pvo= new planVo();
		pvo.setPlan_id(i1);
		companyDao cdo=new companyDao();
		List ls=cdo.delete(pvo);
		h.setAttribute("list", ls);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f=request.getParameter("flag");
		 if (f.equals("Submit")){
			 save(request,response);
			 search1(request,response);
		 }
		 else if (f.equals("Update")){
			 update(request,response);
			 search1(request,response);
		
	}

}

	private void search1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();

		companyDao cdo= new companyDao();
         List<planVo> ls= null;
         ls=cdo.search1();
         h.setAttribute("list", ls);
         response.sendRedirect("admin/viewPlan.jsp");

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i2=Integer.parseInt(request.getParameter("planid"));
		int i=Integer.parseInt(request.getParameter("company"));
		String planname=request.getParameter("planName");
		String plandes=request.getParameter("planDes");
	
		companyVo cvo=new companyVo();
		   cvo.setCompany_ID(i);
	   planVo pvo= new planVo();
	   pvo.setPlan_id(i2);
	   pvo.setPlanName(planname);
	   pvo.setPlanDes(plandes);
	   pvo.setCvo(cvo);
	   pvo.setPlanStatus("Active");
	    companyDao cdo= new companyDao();
	    cdo.update(pvo);
	    
	   
	   
	   
       
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int i2=Integer.parseInt(request.getParameter("company"));
		String planname=request.getParameter("policyPlan");
		String plandes=request.getParameter("planDescription");
		planVo pvo= new planVo();
		pvo.setPlanName(planname);
		pvo.setPlanDes(plandes);
		pvo.setPlanStatus("Active");
		companyVo cvo= new companyVo();
		cvo.setCompany_ID(i2);
		pvo.setCvo(cvo);
		
		companyDao cdo= new companyDao();
		cdo.insert(pvo);
		
		 
		
	
	}

}
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.companyDao;
import vo.companyVo;
import vo.planVo;
import vo.policyName;

/**
 * Servlet implementation class manageName
 */
@WebServlet("/manageName")
public class manageName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageName() {
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
		else if (f1.equals ("loadPlan"))
		{
			loadPlan(request,response);
		}
		else if(f1.equals("edit")){
			edit(request,response);
		}
		else if (f1.equals("Search")){
			 search2(request,response);
	}
    else if (f1.equals("load"))
		 load(request,response);
}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		int id = Integer.parseInt(request.getParameter("companyID"));
		companyVo vo = new companyVo();
		vo.setCompany_ID(id);
		
		companyDao cdo=new companyDao();
		List ls=cdo.loadPlan(vo);
		
		HttpSession h= request.getSession();
		
		h.setAttribute("List", ls);
		System.out.println("LIst SIZE>>>>>>>>>>>>"+ls.size());
		
		response.sendRedirect("admin/loadPolicyPlanJSON.jsp");
		
	}

	private void loadPlan(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		HttpSession h= request.getSession();
		companyDao cdo=new companyDao();
		List ls=cdo.search();
		h.setAttribute("List", ls);
		
		List ls1=cdo.search1();
		h.setAttribute("planlist",ls1);
		response.sendRedirect("admin/Name.jsp");
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		policyName nvo= new policyName();
		nvo.setName_ID(i1);
		companyDao cdo=new companyDao();
		List ls=cdo.edit(nvo);
		h.setAttribute("list", ls);
		
		
		response.sendRedirect("admin/editPolicyName.jsp");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		policyName nvo= new policyName();
		nvo.setName_ID(i1);
		companyDao cdo=new companyDao();
		List ls=cdo.delete(nvo);
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
			 search2(request,response);
		 }
		 else if (f.equals("Update")){
			 update(request,response);
			 search2(request,response);
		
	}

}

	private void search2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();

		companyDao cdo= new companyDao();
         List<policyName> ls= null;
         ls=cdo.search2();
         h.setAttribute("list", ls);
         response.sendRedirect("admin/viewPolicyName.jsp");

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i2=Integer.parseInt(request.getParameter("nameid"));
		int i=Integer.parseInt(request.getParameter("company"));
		int i1=Integer.parseInt(request.getParameter("policyPlan"));
		String policyname=request.getParameter("policyName");
		String policydes=request.getParameter("nameDescription");
	
	
	   planVo pvo= new planVo();
	   pvo.setPlan_id(i1);
	   companyVo cvo =new companyVo();
	   cvo.setCompany_ID(i);
	   policyName nvo= new policyName();
	   nvo.setCvo(cvo);
	   nvo.setPvo(pvo);
	   nvo.setName_ID(i2);
       nvo.setPolicyName(policyname);
       nvo.setPolicyDes(policydes);
	   nvo.setNameStatus("Active");
	   companyDao cdo= new companyDao();
	    cdo.update(nvo);
	    
	   
	   
	   
       
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int i=Integer.parseInt(request.getParameter("company"));
		int i1=Integer.parseInt(request.getParameter("policyPlan"));
		String policyname=request.getParameter("policyName");
		String policydes=request.getParameter("nameDescription");
	
	
	   planVo pvo= new planVo();
	   pvo.setPlan_id(i1);
	   
	   companyVo cvo =new companyVo();
	   cvo.setCompany_ID(i);
	   
	   policyName nvo= new policyName();
	   nvo.setCvo(cvo);
	   nvo.setPvo(pvo);
       nvo.setPolicyName(policyname);
       nvo.setPolicyDes(policydes);
	   
	   companyDao cdo= new companyDao();
	    cdo.insert(nvo);
		}

}
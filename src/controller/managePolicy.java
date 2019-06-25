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
import vo.policyName;

/**
 * Servlet implementation class managePolicy
 */
@WebServlet("/managePolicy")
public class managePolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managePolicy() {
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
			search(request,response);
		}
		else if(f1.equals("edit"))
		{
		   edit(request,response);
		}
		   else if (f1.equals("Search"))
		   {
			   search(request,response);
		   }
			   else if (f1.equals("loadName"))
		{   
		  loadName(request,response);
	}
		else if (f1.equals("load"))
		{
			 load(request,response);
		}
		else if (f1.equals("load1"))
		{
			 load1(request,response);
		}
	}
	private void load1(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

		private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("planid"));
		planVo pvo= new planVo();
		pvo.setPlan_id(id);
        
		
		
		RegDao rdo=new RegDao();
		List ls=rdo.loadName(pvo);
		
		HttpSession h= request.getSession();
		
		h.setAttribute("List", ls);
		System.out.println("List SIZE>>>>>>>>>>>>"+ls.size());
		
		response.sendRedirect("admin/PGJSON.jsp");
		
	}

private void loadName(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		HttpSession h= request.getSession();
		
		companyDao cdo=new companyDao();
		List ls=cdo.search();
		h.setAttribute("companyList", ls);
		
		
		
		response.sendRedirect("admin/InsertPolicyGuideline.jsp");
		
	}
	

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		RegVo rvo = new RegVo();
		rvo.setPg_id(i1);
		
        RegDao rdo= new RegDao();
        List ls=rdo.edit(rvo);
        h.setAttribute("list", ls);
        System.out.println("Policy List : " + ls.size());
        response.sendRedirect("admin/editPolicyGuideline.jsp");
        
        
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		int i1=Integer.parseInt(request.getParameter("id"));
		RegVo rvo= new RegVo();
		rvo.setPg_id(i1);
		RegDao rdo= new RegDao();
		List ls=rdo.delete(rvo);
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
			 search(request,response);
		 }
		 else if (f.equals("Update")){
			 update(request,response);
			 search(request,response);
		 }
			}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(request.getParameter("pgid"));
		int i2=Integer.parseInt(request.getParameter("name"));
	    int i=Integer.parseInt(request.getParameter("company"));
		int i1=Integer.parseInt(request.getParameter("plan"));
		String policyage=request.getParameter("age");
		String policyterm=request.getParameter("term");
		String policyamount=request.getParameter("amount");
	
	
	   planVo pvo= new planVo();
	   pvo.setPlan_id(i1);
	   companyVo cvo =new companyVo();
	   cvo.setCompany_ID(i);
	   policyName nvo= new policyName();
	    nvo.setName_ID(i2);
	    RegVo rvo= new RegVo();
	    rvo.setPg_id(id1);
	    rvo.setAge(policyage);
	    rvo.setAmount(policyamount);
	    rvo.setTerm(policyterm);
        rvo.setCvo(cvo);
        rvo.setPvo(pvo);
        rvo.setNvo(nvo);
       RegDao rdo= new RegDao();
       rdo.update(rvo);
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		HttpSession h=request.getSession();

		RegDao rdo= new RegDao();
         List<RegVo> ls= null;
         ls=rdo.search();
         h.setAttribute("list", ls);
         response.sendRedirect("admin/ViewPolicy.jsp");
         
		
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i2=Integer.parseInt(request.getParameter("name"));
	    int i=Integer.parseInt(request.getParameter("company"));
		int i1=Integer.parseInt(request.getParameter("plan"));
		String policyage=request.getParameter("age");
		String policyterm=request.getParameter("term");
		String policyamount=request.getParameter("amount");
	
	
	   planVo pvo= new planVo();
	   pvo.setPlan_id(i1);
	   companyVo cvo =new companyVo();
	   cvo.setCompany_ID(i);
	   policyName nvo= new policyName();
	    nvo.setName_ID(i2);
	    RegVo rvo= new RegVo();
	    
	    rvo.setAge(policyage);
	    rvo.setAmount(policyamount);
	    rvo.setTerm(policyterm);
        rvo.setCvo(cvo);
        rvo.setPvo(pvo);
        rvo.setNvo(nvo);
       RegDao rdo= new RegDao();
       rdo.insert(rvo);

		
	}

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.companyVo;
import vo.planVo;
import vo.policyName;
import vo.portfolioVo;
import dao.companyDao;
import dao.RegDao_u;

/**
 * Servlet implementation class policyPortfolio
 */
@WebServlet("/policyPortfolio")
public class policyPortfolio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public policyPortfolio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f1=request.getParameter("flag1");
		 if (f1.equals ("loadPlan"))
		{
			loadPlan(request,response);
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
	
	System.out.println("List Size>>>>>>>>"+ls.size());
	//List ls1=cdo.search1();
	//h.setAttribute("planlist",ls1);
	response.sendRedirect("user/policyPortfolio.jsp");
	
}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f=request.getParameter("flag");
		if( f.equals("Submit"))
		 {
			 search(request,response);
		 }
		

}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i=Integer.parseInt(request.getParameter("company"));
		int i1=Integer.parseInt(request.getParameter("policyPlan"));
		String policyno=request.getParameter("policyNo");
		HttpSession h=request.getSession();
	
	
	   planVo pvo= new planVo();
	   pvo.setPlan_id(i1);
	   
	   companyVo cvo =new companyVo();
	   cvo.setCompany_ID(i);
	   
	 portfolioVo povo = new portfolioVo();
	 povo.setPolicyNumber(policyno);
	 povo.setCvo(cvo);
	 povo.setPvo(pvo);
	   
	   RegDao_u cdo= new RegDao_u();
	   List ls= cdo.search(povo);
	   h.setAttribute("list", ls);
	   
	   System.out.println("size"+ls.size());
	   response.sendRedirect("user/policyPortfolio1.jsp");
		}	
	}

		
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

import dao.RegDao;
import dao.agentDao;
import vo.RegVo;
import vo.clientVo;
import vo.companyVo;
import vo.policyVo;

/**
 * Servlet implementation class policyInsert
 */
@WebServlet("/policyInsert")
public class policyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public policyInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String f1=request.getParameter("flag1");
		if(f1.equals("delete")){
			delete(request,response);
			search1(request,response);
		}
		else if(f1.equals("edit"))
		{
			edit(request,response);
		}
		else if (f1.equals("Search"))
		{	 search1(request,response);	
	}
		}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i2 = Integer.parseInt(request.getParameter("id"));
		HttpSession h = request.getSession();
		policyVo pvo = new policyVo();
		pvo.setPolicy_Id(i2);
		agentDao ado = new agentDao();
		List ls = new ArrayList();
		ls = ado.edit(pvo);
		h.setAttribute("list", ls);
		response.sendRedirect("Agent/editPolicy.jsp");
		
		

		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession h = request.getSession();
		int i1 = Integer.parseInt(request.getParameter("id"));
		policyVo pvo = new policyVo();
		pvo.setPolicy_Id(i1);
		agentDao ado = new agentDao();
		List ls = ado.delete(pvo);
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
		 }
		 else if (f.equals("Update")){
			 update(request,response);
			 search1(request,response);
		 }
			}


	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i2 = Integer.parseInt(request.getParameter("policyid"));
		String policyname=request.getParameter("policyName");
		String amountpolicy=request.getParameter("amountPolicy");
		String numberpolicy=request.getParameter("numberPolicy");
		String companypolicy=request.getParameter("companyPolicy");
		String typePolicy=request.getParameter("typePolicy");
		String planpolicy=request.getParameter("planPolicy");	
		String termpolicy=request.getParameter("termPolicy");
		
		policyVo pvo=new policyVo();
		pvo.setPolicy_Id(i2);
		pvo.setPolicyCompany(companypolicy);
		pvo.setPolicyName(policyname);
		pvo.setPolicyAmount(amountpolicy);
		pvo.setPolicyType(typePolicy);
		pvo.setPolicyNumber(numberpolicy);
		pvo.setPolicyPlan(planpolicy);
        pvo.setPolicyTerm(termpolicy);		
		
	
		
		
		
		agentDao ado = new agentDao();
		ado.update(pvo);
		
	}

	private void search1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h = request.getSession();

		agentDao ado = new agentDao();
		List<policyVo> ls = null;
		ls = ado.search1();
		h.setAttribute("list", ls);
		response.sendRedirect("Agent/viewNewPolicy.jsp");

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String policyname=request.getParameter("policyName");
		String amountpolicy=request.getParameter("amountPolicy");
		String numberpolicy=request.getParameter("numberPolicy");
		String companypolicy=request.getParameter("companyPolicy");
		String typePolicy=request.getParameter("typePolicy");
		String planpolicy=request.getParameter("planPolicy");	
		String termpolicy=request.getParameter("termPolicy");
		
		System.out.println(amountpolicy);
		System.out.println(numberpolicy);
		System.out.println(typePolicy);
		
		policyVo pvo=new policyVo();
		pvo.setPolicyCompany(companypolicy);
		pvo.setPolicyName(policyname);
		pvo.setPolicyAmount(amountpolicy);
		pvo.setPolicyType(typePolicy);
		pvo.setPolicyNumber(numberpolicy);
		pvo.setPolicyPlan(planpolicy);
        pvo.setPolicyTerm(termpolicy);		
        
        
	
		
		
		
        agentDao ado = new agentDao();
		ado.insert(pvo);
		response.sendRedirect("Agent/insertPolicy.jsp");
	}
	}



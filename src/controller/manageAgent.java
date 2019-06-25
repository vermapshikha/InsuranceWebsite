package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.agentRegDao;
import dao.companyDao;
import dao.countryDao;
import vo.agentVo;
import vo.cityVo;
import vo.companyVo;
import vo.countryVo;
import vo.stateVo;

/**
 * Servlet implementation class manageAgent
 */
@WebServlet("/manageAgent")
public class manageAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageAgent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		if(flag.equals("search"))
		{
			search(request,response);
		}
		else if(flag.equals("load"))
		{
			load(request,response);
		}
		else if(flag.equals("delete"))
		{
			delete(request,response);
		}
			
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession h= request.getSession();
		companyDao cdo=new companyDao();
		List ls=cdo.search();
		h.setAttribute("companyList", ls);
		
		countryVo cvo= new countryVo();
		countryDao codo= new countryDao();
		List list=codo.search(cvo);
		h.setAttribute("countryList", list);
		
		stateVo svo= new stateVo();
		List list1=codo.search1(svo);
		h.setAttribute("stateList",list1);
		response.sendRedirect("Agent/agentRegister.jsp");
		
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
		}
		
			
	}

	private void submit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("agentName");
		String dob= request.getParameter("DOBAgent");
		String phone= request.getParameter("telephoneAgent");
		String email= request.getParameter("emailAgent");
		String address= request.getParameter("agentAddress");
		String gender= request.getParameter("agentGender");
		int i1=Integer.parseInt(request.getParameter("country"));
		int i2=Integer.parseInt(request.getParameter("state"));
		int i3= Integer.parseInt(request.getParameter("city"));
		int i4= Integer.parseInt(request.getParameter("company"));
		String description= request.getParameter("agentDes");
		
		countryVo cvo= new countryVo();
		cvo.setCountry_ID(i1);
		
		stateVo svo= new stateVo();
		svo.setState_ID(i2);
		
		cityVo civo = new cityVo();
		civo.setCity_ID(i3);
		
        
		companyVo  covo= new companyVo();
        covo.setCompany_ID(i4);
        
        agentVo avo = new agentVo();
        avo.setAgentName(name);
        avo.setAgentDOB(dob);
        avo.setAgentEmail(email);
        avo.setAgentGender(gender);
        avo.setAgentPhone(phone);
        avo.setCountryID(cvo);
        avo.setStateID(svo);
        avo.setCityID(civo);
        avo.setCompanyID(covo);
        avo.setAgentAddress(address);
        avo.setAgentDes(description);
        
        agentRegDao ardo= new agentRegDao();
        ardo.insert(avo);
        response.sendRedirect("Agent/index.jsp");
	}

}

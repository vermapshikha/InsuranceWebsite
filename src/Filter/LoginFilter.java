 package Filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.loginDao;
import vo.loginVo;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/smll") //do * for the filter on and any other notation for filter off
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("flag");
		
		String uri = ((HttpServletRequest) request).getRequestURI();

	System.out.println("<<<<<Before >>>>>>>"+uri);
		
		if(uri.contains("manageRegister")||uri.contains("/css")  ||uri.contains("/forgot1.jsp") ||uri.contains("forgot2.jsp") ||uri.contains("managePassword") ||uri.contains("/js") &&!uri.contains(".jsp") ||uri.contains("/img") ||uri.contains("/images") ||uri.contains("/login.jsp") ||uri.contains("/fonts") ||uri.contains("/Register.jsp"))
		
		{
			System.out.println("<<<<<After >>>>>>>"+uri);
			chain.doFilter(request, response);
		}
		else if (flag!= null && flag.equals("logout")){
			
			session.invalidate();
			requestDispatcher = request.getRequestDispatcher("/Agent/login.jsp");
			requestDispatcher.forward(request, response);
		}
		else if (flag!= null && flag.equals("login"))
		{
          String uname = request.getParameter("uname");
          String pass = request.getParameter("pass");
          
          System.out.println(uname+""+pass);
          
          loginVo loginVO = new loginVo();
          loginVO.setUserName(uname);
          loginVO.setPassWord(pass);
          
          loginDao registrationDAO = new loginDao(); 
          
			List list =  registrationDAO.authentication(loginVO);
			System.out.println("list Size>>>>>>>>>>"+list.size());
			if(list != null && list.size()>=1){
				
				//Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				loginVo user=(loginVo) list.get(0);
				
				int y = user.getLogin_ID();
				session.setAttribute("userID",y);
				
			//	System.out.println(user.getRadio());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getUser_type();
				session.setAttribute("userType",type);
				System.out.println(y);
				System.out.println(type);
				
				if(type.equalsIgnoreCase("admin"))
				{
					requestDispatcher = request.getRequestDispatcher("/admin/Index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("user"))
				{
					requestDispatcher = request.getRequestDispatcher("/user/Home2.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("agent"))
				{
					requestDispatcher = request.getRequestDispatcher("/Agent/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				
				else
				{
					requestDispatcher = request.getRequestDispatcher("/Agent/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("/Agent/login.jsp");
				requestDispatcher.forward(request,response);  		
			}	
		}
		else if(session.getAttribute("userID") != null)
		{
			String h = (String)session.getAttribute("userType");
			//System.out.println("type = = = " + h);
			
			if(h!=null && h.equals("admin")){
				
			//System.out.println("chain");
			chain.doFilter(request,response);
			}
			
			else if(h!=null && h.equals("user"))
			{
				//System.out.println("chain");
				chain.doFilter(request,response);
			}
	
			else if(h!=null && h.equals("agent"))
			{
				//System.out.println("chain");
				chain.doFilter(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Agent/login.jsp");  
				rd.forward(request,response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Agent/login.jsp");  
			rd.forward(request,response);  
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

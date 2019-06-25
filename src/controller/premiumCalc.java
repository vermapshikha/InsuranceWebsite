package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class premiumCalc
 * @param <var>
 */
@WebServlet("/premiumCalc")
public class premiumCalc<var> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public premiumCalc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String age1=request.getParameter("age");
        String amount=request.getParameter("amount");
        String t=request.getParameter("t");
        String year=request.getParameter("year");
        HttpSession h=request.getSession();
        float p=Float.parseFloat(amount);
        float age=Float.parseFloat(age1);
        float y=Float.parseFloat(year);
        if(t=="Yearly")
        {
        float totamount = (y*p)+(y*500*41);
        h.setAttribute("fund", totamount);
        }
        else
        {
        float totamount = (p*12*y)+(y*500*41);
        h.setAttribute("fund", totamount);
        }
       
        
      response.sendRedirect("Agent/premiumCal.jsp");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

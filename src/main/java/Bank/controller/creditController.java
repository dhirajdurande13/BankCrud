package Bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bank.dao.registerDaoimp;
import Bank.dao.registerdao;
import Bank.model.account;
import Bank.model.credit;

/**
 * Servlet implementation class creditController
 */
@WebServlet("/creditController")
public class creditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regNo=Integer.parseInt(request.getParameter("regNo"));
		float accBal=Float.parseFloat(request.getParameter("accBal"));
		credit cred=new credit(regNo, accBal);
		registerdao reg=new registerDaoimp();
		int i=reg.creditBal(cred);
		 HttpSession session=request.getSession();
		if(i>0)
		{
			System.out.println("credited");
			response.sendRedirect("Home.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

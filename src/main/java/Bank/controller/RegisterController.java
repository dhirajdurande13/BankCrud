package Bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bank.dao.registerDaoimp;
import Bank.dao.registerdao;
import Bank.model.account;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regNo= Integer.parseInt(request.getParameter("regNo"));
		String custName=request.getParameter("custName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		float accBal=Float.parseFloat(request.getParameter("accBal"));
		account acc=new account(regNo, custName, username, password, accBal);
		registerdao reg=new registerDaoimp();
		List<account> lst=new  ArrayList<account>();
		lst.add(acc);
		int i=reg.create(lst);
		if(i>0)
		{
			response.sendRedirect("Login.jsp");
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

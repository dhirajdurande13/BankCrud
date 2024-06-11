package Bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bank.dao.registerDaoimp;
import Bank.dao.registerdao;
import Bank.model.account;

/**
 * Servlet implementation class displayController
 */
@WebServlet("/displayController")
public class displayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerdao reg=new registerDaoimp();
		List<account> lst= reg.display();
//		HttpSession session =request.getSession();
//		
//			session.setAttribute("data", lst);
//			response.sendRedirect("DisplayView.jsp");
		    
		
//		}else {
//			System.out.println("error cooured!");
//		}
//		
		
		request.setAttribute("accList", lst);
		 RequestDispatcher view= request.getRequestDispatcher("DisplayView.jsp");
		 view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

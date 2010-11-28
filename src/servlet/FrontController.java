package servlet;

import controllers.*;
import beans.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	
	// parameters shared with login.jsp.  These must exactly match the 
    // property names in the JSP.
 /*   public static final String USERNAME_PARAM = "username";
    public static final String PASSWORD_PARAM = "password";
    public static final String USERBEAN_ATTR = "userbean";
*/    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "error.jsp";
		String uri = request.getRequestURI();
		
		System.out.println("uri début: " + uri);
		
		page = LogginController.process(request, response);
        
        if(uri.matches(".*/image")) {
			page = ImageController.process(request,response);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		System.out.println("uri : " + uri);
		System.out.println("Fowarding to : " + page);

		if(page != null) {
			dispatcher.forward(request, response);
		}
	}
}

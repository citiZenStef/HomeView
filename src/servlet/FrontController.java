package servlet;

import controllers.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
 
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
		
		//page will later be changed in case of uri match, except for the case it returns index.jsp (login failed)
		page = LogginController.process(request, response);
        
        if(uri.matches(".*/image") && !page.equals("index.jsp")) {
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

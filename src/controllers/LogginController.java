package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

public class LogginController {
	
	// parameters shared with login.jsp.  These must exactly match the 
    // property names in the JSP.
    public static final String USERNAME_PARAM = "username";
    public static final String PASSWORD_PARAM = "password";
    public static final String USERBEAN_ATTR = "userbean";
    
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		HttpSession session = request.getSession(true);
		UserBean userBean = (UserBean) session.getAttribute(USERBEAN_ATTR);
        
        if (userBean == null || !userBean.isLoggedIn()) {
            // read request parameters
            String username = request.getParameter(USERNAME_PARAM);
            String password = request.getParameter(PASSWORD_PARAM);
            
            // if the userbean doesn't exists, create it
            if (userBean == null) {
                userBean = UserBeanFactory.newInstance();
                session.setAttribute(USERBEAN_ATTR, userBean);
            }
            
            // record the username and password values
            userBean.setUsername(username);
            userBean.setPassword(password);
            
            // attempt to login
            boolean result = userBean.doLogin();
            System.out.println(result);
            
            // if we failed, redirect to the login page
            if (!result) {
                page = "index.jsp";
            }
        }
        
        else {
        	page = "testPage.jsp";
        }
        
        return page;
	}
}

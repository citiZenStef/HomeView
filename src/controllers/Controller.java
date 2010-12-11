package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Utiliser cette interface aussitôt qu'on saura comment
 * Guice fonctionne. -_-
 * @author Stef 
 *
 */

public interface Controller {
	public String process(HttpServletRequest request, HttpServletResponse response);
}

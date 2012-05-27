package org.paulobichara.ejbexample.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.paulobichara.ejbexample.ejb.TesteBean;
/**
 * This is the servlet class. 
 * As simple as possible, it only consumes the EJB getMessage()
 * method in two different ways and writes both outputs to response
 * output stream.
 * 
 * @author Paulo Bichara
 *
 */
public class TesteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8700382872352303887L;

	/**
	 * TesteBean attribute injected directly through EJB annotation
	 */
	@EJB
	private TesteBean testeBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = testeBean.getMessage();
		TesteController controller = new TesteController();
		/* In the next line, TesteServlet consumes the TesteBean EJB by direct injection through testeBean attribute */
		response.getOutputStream().println("<html><body>Message received: " + message + "</body></html>");
		/* In the next line, TesteController will act as a proxy between TesteServlet and TesteBean */
		response.getOutputStream().println("<html><body>Message received through controller: " + controller.getMessage() + "</body></html>");		
	}

}

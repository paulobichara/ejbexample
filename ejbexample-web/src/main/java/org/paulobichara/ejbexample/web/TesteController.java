package org.paulobichara.ejbexample.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.paulobichara.ejbexample.ejb.TesteBean;

/**
 * Class acting as a proxy to TesteBean. The purpose is to exemplify
 * EJB discovery through JNDI lookup in JBoss AS 7.1.1 way.
 * @author monk
 *
 */
public class TesteController {

	private TesteBean testeBean;

	/**
	 * Method that finds the EJB through context lookup and then returns
	 * getMessage() method return from TesteBean to caller.
	 * @return
	 */
	public String getMessage() {
		try {
			InitialContext ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:");			
			testeBean = (TesteBean)envCtx.lookup("java:global/ejbexample/ejbexample-ejb-0.0.1-SNAPSHOT/TesteBean");
			return testeBean.getMessage();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

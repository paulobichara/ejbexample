package org.paulobichara.ejbexample.ejb;

import javax.ejb.Stateless;

/***
 * This is the EJB itself.
 * @author monk
 *
 */
@Stateless
public class TesteBean {

	/**
	 * Method that returns one test String message.
	 * @return test String message
	 */
	public String getMessage() {
		return "Hey!";
	}
	
}

package com.sendable.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.smartcardio.Card;

import sendable.dao.repository.Repository;
import sendable.logic.interfaces.CardInterface;
import sendable.logic.services.CardService;

/**
 * Application Lifecycle Listener implementation class SendableListener
 *
 */
@WebListener
public class SendableListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SendableListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {

		// Card Repository
		arg0.getServletContext().setAttribute("cardService", 
				new CardService(new Repository<sendable.dao.entities.Card>(Card.class)));
	}

}

package com.sendable.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import sendable.dao.database.DatabaseManager;
import sendable.dao.interfaces.DatabaseManagerInterface;
import sendable.dao.repository.UnitOfWork;
import sendable.logic.services.CardService;
import sendable.logic.services.PaymentService;
import sendable.logic.services.UserService;


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
		
		DatabaseManagerInterface database = new DatabaseManager();
		
		UnitOfWork uow = new UnitOfWork(database);
		
		arg0.getServletContext()
		.setAttribute("cardService",new CardService(uow));
		
		arg0.getServletContext()
		.setAttribute("userService",new UserService(uow));
		
		arg0.getServletContext()
		.setAttribute("paymentService",new PaymentService(uow));
		
	}
}

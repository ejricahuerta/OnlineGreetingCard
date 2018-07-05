package com.sendable.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import sendable.dao.database.DatabaseManager;
import sendable.dao.entities.Card;
import sendable.dao.interfaces.DatabaseManagerInterface;
import sendable.dao.repository.UnitOfWork;
import sendable.logic.dtos.CategoryDto;
import sendable.logic.interfaces.CardInterface;
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
		CardInterface cardservice = new CardService(uow);
		arg0.getServletContext()
			.setAttribute("db", database);
		arg0.getServletContext()
			.setAttribute("uow", uow);
		arg0.getServletContext()
			.setAttribute("cardService",cardservice);
		arg0.getServletContext()
			.setAttribute("userService",new UserService(uow));
		arg0.getServletContext()
			.setAttribute("paymentService",new PaymentService(uow));
		
		List<CategoryDto> allcat = cardservice.ListCategories();
		arg0.getServletContext().setAttribute("allcategories", allcat);
	}
}

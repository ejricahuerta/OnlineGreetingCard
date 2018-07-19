package com.sendable.serlvet.config;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import data.mock.SeedDatabase;
import sendable.dao.database.DatabaseManager;
import sendable.dao.entities.Card;
import sendable.dao.entities.Category;
import sendable.dao.interfaces.DatabaseManagerInterface;
import sendable.dao.interfaces.UnitOfWorkInterface;
import sendable.dao.repository.UnitOfWork;
import sendable.logic.dtos.CardDto;
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
public class SendableContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SendableContextListener() {
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
		UnitOfWorkInterface uow = new UnitOfWork(database);
		if(uow.GetCategoryRepo().ListAll().isEmpty()) {
			SeedDatabase seed = new SeedDatabase(uow);
			seed.SeedCard();
			
		}
		CardInterface cardservice = new CardService(uow);
		List<CardDto> allcards = cardservice.ListCards();
		List<CategoryDto> allcat = cardservice.ListCategories();
		arg0.getServletContext().setAttribute("allcards", allcards);
		arg0.getServletContext().setAttribute("allcategories", allcat);
		arg0.getServletContext().setAttribute("cardService", cardservice);
		arg0.getServletContext().setAttribute("userService", new UserService(uow));
		arg0.getServletContext().setAttribute("paymentService", new PaymentService(uow));
	}
}
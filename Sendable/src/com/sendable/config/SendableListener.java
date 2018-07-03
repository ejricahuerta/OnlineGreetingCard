package com.sendable.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import sendable.dao.entities.Account;
import sendable.dao.entities.Card;
import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Category;
import sendable.dao.entities.Payment;
import sendable.dao.entities.User;
import sendable.dao.repository.Repository;

import sendable.logic.services.CardService;
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

		// Card Repository
		arg0.getServletContext().setAttribute("cardService", 
				new CardService(new Repository<Card>(Card.class), 
								new Repository<Category>(Category.class)));
		arg0.getServletContext().setAttribute("userService",
				new UserService(new Repository<User>(User.class), 
						new Repository<CardLetter>(CardLetter.class),
						new Repository<Card>(Card.class), 
						new Repository<Account>(Account.class),
						new Repository<Payment>(Payment.class))
				);
		
		
	
	}

}

package com.sendable.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import sendable.dao.database.SeedDatabase;


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

		SeedDatabase seed = new SeedDatabase();
		arg0.getServletContext().setAttribute("categories",seed.AddCategories());
	}
}

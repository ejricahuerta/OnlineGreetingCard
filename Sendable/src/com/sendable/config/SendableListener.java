package com.sendable.config;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import data.mock.SeedDatabase;
import sendable.dao.database.DatabaseManager;
import sendable.dao.entities.Card;
import sendable.dao.entities.Category;
import sendable.dao.interfaces.DatabaseManagerInterface;
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

		SeedDatabase seed = new SeedDatabase();

		if (uow.GetCategoryRepo().ListAll().isEmpty()) {
			for (Category c : seed.AddCategories()) {
				try {

					System.out.println("Adding: " + c.getName());
					uow.GetCategoryRepo().Insert(c);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					uow.Save();
				}
			}
		}

		

		
		if(uow.GetCardRepo().ListAll().isEmpty()) {
			Category c1 = uow.GetCategoryRepo().Get(1);
			try {
			if(c1.getCards().isEmpty()) {
				uow.GetCardRepo()
				.Insert(new Card(c1, "Special Day", "Birthday Wishes on your Special day", 5, "images/birthdays/bday1.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Yum", "Happy Birthday to you!", 5, "images/birthdays/bday2.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Balloons", "From all of Us!", 5, "images/birthdays/bday3.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Special Day", "Birthday Wishes on your Special day", 5, "images/birthdays/bday4.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "To you", "Happy Birthday to you!", 5, "images/birthdays/bday5.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Birthday Ass", "Happy Birthday to your Ass!", 5, "images/birthdays/bday6.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Me", "Present for you!", 5, "images/birthdays/bday6.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Old", "Old is the new black!", 5, "images/birthdays/bday7.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "18th", "Happy 18th Birthday!", 5, "images/birthdays/bday8.jpeg", true));
				uow.GetCardRepo()
				.Insert(new Card(c1, "Dad Birthday", "I Love you dad! Happy Birthday!", 5, "images/birthdays/bday9.jpeg", true));
			}
			uow.Save();			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		uow.Close();

		List<Card> cards =  uow.GetCardRepo().ListAll();
		for (Card card : cards) {
			Category ct = uow.GetCategoryRepo().Get(card.getCategory().getId());
			ct.getCards().add(card);
			uow.GetCategoryRepo().Update(ct);
		}
		
		uow.Save();
		List<CardDto> allcards = cardservice.ListCards();
		List<CategoryDto> allcat = cardservice.ListCategories();
		arg0.getServletContext().setAttribute("allcategories", allcat);
		arg0.getServletContext().setAttribute("allcards", allcards);
		arg0.getServletContext().setAttribute("db", database);
		arg0.getServletContext().setAttribute("uow", uow);

		arg0.getServletContext().setAttribute("cardService", cardservice);
		arg0.getServletContext().setAttribute("userService", new UserService(uow));
		arg0.getServletContext().setAttribute("paymentService", new PaymentService(uow));
	}
}

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

		if (uow.GetCardRepo().ListAll().isEmpty()) {

			// Birthday!
			Category c1 = uow.GetCategoryRepo().Get(1);
			try {
				if (c1.getCards().isEmpty()) {
					uow.GetCardRepo().Insert(new Card(c1, "Special Day", "Birthday Wishes on your Special day", 5,
							"images/birthdays/bday1.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c1, "Yum", "Happy Birthday to you!", 5, "images/birthdays/bday2.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c1, "Balloons", "From all of Us!", 5, "images/birthdays/bday3.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c1, "Simple", "Happy Happy Birthday!", 5, "images/birthdays/bday4.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c1, "Birthday Ass", "Happy Birthday to your Ass!", 5,
							"images/birthdays/bday5.jpeg", true));
					uow.GetCardRepo()
							.Insert(new Card(c1, "Me", "Present for you!", 5, "images/birthdays/bday6.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c1, "Old", "Old is the new black!", 5, "images/birthdays/bday7.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c1, "18th", "Happy 18th Birthday!", 5, "images/birthdays/bday8.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c1, "Dad Birthday", "I Love you dad! Happy Birthday!", 5,
							"images/birthdays/bday9.jpeg", true));
				}

				// Aniversaries
				Category c2 = uow.GetCategoryRepo().Get(2);
				if (c2.getCards().isEmpty()) {
					uow.GetCardRepo().Insert(new Card(c2, "Stephen", "To my Boyfriend Stephen", 6.0,
							"images/aniversaries/anv1.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c2, "Stick Figure", "Redundancy is Love!", 5.0,
							"images/aniversaries/anv2.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c2, "Air Ballloon", "Birds and Air Balloon on Aniverasary", 6.0,
							"images/aniversaries/anv3.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c2, "25th Aniversary", "Congratultion on your Aniverary", 7.0,
							"images/aniversaries/anv4.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c2, "Hearts", "All hearts just for you!", 6.0,
							"images/aniversaries/anv5.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c2, "Flowers", "Simple Greetings on your Aniversary", 6.0,
							"images/aniversaries/anv6.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c2, "Embedded", "Custom Aniversary Card", 6.0,
							"images/aniversaries/anv7.jpeg", true));
				}

				// Chrstmas
				Category c3 = uow.GetCategoryRepo().Get(3);
				if (c3.getCards().isEmpty()) {
					uow.GetCardRepo()
							.Insert(new Card(c3, "Tree", "Lets Get Merry!", 7.0, "images/christmas/xmas1.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c3, "Peace", "Love Peace and Hope on Christmas!", 7.0,
							"images/christmas/xmas2.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c3, "Santa's Cart", "Card on a Box!", 7.0, "images/christmas/xmas3.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c3, "Happy Holidays", "Holiday Cards with Mutli Colors", 7.0,
							"images/christmas/xmas4.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c3, "Santa", "Santa's Chimney!", 7.0, "images/christmas/xmas5.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c3, "Silver", "Silver and Gold Card!", 7.0, "images/christmas/xmas1.jpeg", true));
				}

				Category c4 = uow.GetCategoryRepo().Get(4);
				if (c4.getCards().isEmpty()) {
					uow.GetCardRepo().Insert(new Card(c4, "Be my Valentine", "Arrows and Heart!", 10.0,
							"images/valentines/val1.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c4, "Arrow Heart", "Arrows and Heart 2!", 8.0,
							"images/valentines/val2.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c4, "Always", "Always Valentine Card", 6.0, "images/valentines/val3.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c4, "All for YOU", "All my love for you!", 5.0,
							"images/valentines/val4.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c4, "Full of Hearts", "Multi Hearted Card", 10.0,
							"images/valentines/val5.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c4, "Valentinja", "Ninja Greeting Valentine!", 10.0,
							"images/valentines/val6.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c4, "For Husband", "From Wife of course!", 10.0,
							"images/valentines/val7.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c4, "Catcus Love", "Read the text!", 10.0, "images/valentines/val8.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c4, "Lovester", "A lovely Lobster!", 10.0, "images/valentines/val9.jpeg", true));
					uow.GetCardRepo().Insert(new Card(c4, "Stick Love", "Two Buttons Kissing!", 10.0,
							"images/valentines/val10.jpeg", true));
					uow.GetCardRepo().Insert(
							new Card(c4, "Cute Love", "Pets and Love!", 10.0, "images/valentines/val1.jpeg", true));
				}
				
				uow.Save();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<Card> cards = uow.GetCardRepo().ListAll();
		for (Card card : cards) {
			Category ct = uow.GetCategoryRepo().Get(card.getCategory().getId());
			ct.getCards().add(card);
			uow.GetCategoryRepo().Update(ct);
		}
		List<CardDto> allcards = cardservice.ListCards();
		List<CategoryDto> allcat = cardservice.ListCategories();
		arg0.getServletContext().setAttribute("allcards", allcards);
		arg0.getServletContext().setAttribute("db", database);
		arg0.getServletContext().setAttribute("uow", uow);
		
		arg0.getServletContext().setAttribute("allcategories", allcat);
		arg0.getServletContext().setAttribute("cardService", cardservice);
		arg0.getServletContext().setAttribute("userService", new UserService(uow));
		arg0.getServletContext().setAttribute("paymentService", new PaymentService(uow));
	}
}
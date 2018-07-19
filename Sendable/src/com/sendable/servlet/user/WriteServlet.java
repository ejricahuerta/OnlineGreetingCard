package com.sendable.servlet.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.dao.entities.DateTime;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;
import sendable.logic.services.CardService;
import sendable.logic.services.UserService;

/**
 * Servlet implementation class WriteServlet
 */
/**
 * @author ejricahuerta
 *
 */
@WebServlet("/Write")
public class WriteServlet extends HttpServlet {

	private CardService cardservice;

	private UserService userservice;

	private ServletContext context;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("userId") == null) {
			resp.sendRedirect("login.jsp");
		} 
		else {

			int cardId = Integer.parseInt(req.getParameter("cardId"));

			CardDto cardSelected = this.cardservice.getCard(cardId);
			if (cardSelected == null) {
				resp.sendRedirect("cards.jsp");
			} else {
				req.setAttribute("cardSelected", cardSelected);
				req.setAttribute("type", "Write");
				req.setAttribute("font", "font1");
				req.getRequestDispatcher("write.jsp").forward(req, resp);
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = req.getParameter("message");
		String recipient = req.getParameter("recipient");
		String font = req.getParameter("font");
		int cardId = Integer.parseInt(req.getParameter("cardId"));

		if (message.isEmpty() || recipient.isEmpty() || message.length() < 4) {
			req.setAttribute("validationMessage", "<b>Invalid Message or Recipient!</b> Please try again.");
			req.getRequestDispatcher("write.jsp").forward(req, resp);
			;
		} else {
			int userId = (int) req.getSession().getAttribute("userId");
			CardDto cardSelected = this.cardservice.getCard(cardId);
			CardLetterDto newletter = new CardLetterDto(0, userId, cardId, recipient, message, font,
					cardSelected.getPrice() * (1.13), DateTime.GetCurrentDate());
			int newLetterId = this.userservice.addUserLetter(userId, newletter);
			if (newLetterId == -1) {
				this.context.log("Unable to add new Letter");
				req.setAttribute("validationMessage", "<b>Invalid Message or Recipient!</b> Please try again.");
				req.getRequestDispatcher("write.jsp").forward(req, resp);
			} else {
				this.userservice.saveChanges();
				if (req.getParameter("button").equals("Save")) {
					resp.sendRedirect("MyAccount");

				} else {
					resp.sendRedirect("Payment?letterId=" + newLetterId);
				}

			}
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		this.context = (ServletContext) config.getServletContext();

		this.cardservice = (CardService) config.getServletContext().getAttribute("cardService");

		this.userservice = (UserService) config.getServletContext().getAttribute("userService");

	}

}

package com.sendable.servlet.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
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
@WebServlet("/Write")
public class WriteServlet extends HttpServlet {

	private CardService cardservice;

	private UserService userservice;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteServlet() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter("message");
		String recipient = request.getParameter("recipient");
		String font = request.getParameter("font");

		int cardId = Integer.parseInt(request.getParameter("cardId"));
		CardDto card = cardservice.getCard(cardId);
		request.setAttribute("cardSelected", card);
		
		if (message == null || message.length() < 5) {
			request.setAttribute("validationMessage", "<b>Invalid Message!</b> Please Enter your message again.");

		} else if (recipient == null) {
			request.setAttribute("validationMessage", "<b>Invalid Recipient!</b> Please Enter your message again.");
			request.getRequestDispatcher("write.jsp").forward(request, response);
		} else {
			String button = request.getParameter("button");
			int userId = (int) request.getSession().getAttribute("userId");
			CardLetterDto newLetter = new CardLetterDto(0, userId, cardId, recipient, message, font,
					card.getPrice(), DateTime.GetCurrentDate());
			int letterId = this.userservice.addUserLetter(userId, newLetter);

			if (letterId != -1) {
				this.userservice.saveChanges();
				UserDto updatedUser = this.userservice.findUserById(userId);
				request.getSession().setAttribute("user", updatedUser);
				newLetter = this.userservice.getUserLetter(userId, letterId);
				request.setAttribute("letter", newLetter);
				if(button.equals("Pay Now")) {
					request.getRequestDispatcher("payment.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("myaccount.jsp").forward(request, response);
				}
				
			} else {
				request.setAttribute("validationMessage", "<b>Unable to Proccess!</b>Please Re-Enter Message.");
				request.getRequestDispatcher("write.jsp").forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ID: " + request.getParameter("cardId"));
		if (request.getParameter("cardId") == null) {
			response.sendRedirect(request.getContextPath() + "/card.jsp");
		} else {
			int id = Integer.parseInt(request.getParameter("cardId"));
			CardDto card = cardservice.getCard(id);
			request.setAttribute("cardSelected", card);
			request.getRequestDispatcher("write.jsp").forward(request, response);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.cardservice = (CardService) config.getServletContext().getAttribute("cardService");
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
	}

}

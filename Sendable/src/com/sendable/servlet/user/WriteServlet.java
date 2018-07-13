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
@WebServlet("/Write/*")
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
		try {

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
					if (button.equals("Pay Now")) {
						request.getRequestDispatcher("payment.jsp").forward(request, response);
					} else {
						response.sendRedirect("myaccount.jsp");
					}

				} else {
					request.setAttribute("validationMessage", "<b>Unable to Proccess!</b>Please Re-Enter Message.");
					request.getRequestDispatcher("write.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CARD ID: " + request.getParameter("cardId"));
		System.out.println("LETTER ID" + request.getParameter("letterId"));
		try {
			if (request.getParameter("cardId") == null) {
				if(request.getParameter("letterId") != null) {
					int letterId = Integer.parseInt(request.getParameter("letterId"));
					int userId = (int)request.getSession().getAttribute("userId");
					CardLetterDto letter =  this.userservice.getUserLetter(userId, letterId);
					System.out.println(letter.getMessage());
					if(letter != null) {
						request.setAttribute("message", letter.getMessage());
						request.setAttribute("recipient", letter.getRecipient());
						request.getRequestDispatcher("Write?cardId="+letter.getCardId()).forward(request, response);
						
					}
					
				}
				else {
				response.sendRedirect(request.getContextPath() + "/cards.jsp");
				}
			} else {
				int id = Integer.parseInt(request.getParameter("cardId"));
				CardDto card = cardservice.getCard(id);
				request.setAttribute("cardSelected", card);
				request.getRequestDispatcher("write.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.cardservice = (CardService) config.getServletContext().getAttribute("cardService");
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
	}

}

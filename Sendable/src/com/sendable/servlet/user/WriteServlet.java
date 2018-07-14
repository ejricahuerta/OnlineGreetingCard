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

		System.out.println("CARD ID: " + request.getParameter("cardId"));
		System.out.println("LETTER ID" + request.getParameter("letterId"));

		if (request.getParameter("cardId") != null) {
			this.proccesCardRequest(request, response, true);
		}

		if (request.getParameter("letterId") != null) {
			int userId = (int) request.getSession().getAttribute("userId");
			int letterId = Integer.parseInt(request.getParameter("letterId"));
			this.proccesLetterRequest(request, response, (this.userservice.getUserLetter(userId, letterId) != null),
					true);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("cardId") != null) { // is a card
			this.context.log("Processing letter request.");
			this.proccesCardRequest(request, response, false);
		}
		if (request.getParameter("letterId") != null) {
			int userId = (int) request.getSession().getAttribute("userId");
			int letterId = Integer.parseInt(request.getParameter("letterId"));
			this.proccesLetterRequest(request, response, (this.userservice.getUserLetter(userId, letterId) != null),
					false);
		} else {
			response.sendRedirect("cards.jsp");
			return;
		}
	}

	/**
	 * @param req
	 * @param res
	 * @param isPost
	 * @throws IOException
	 * @throws ServletException
	 */
	private void proccesCardRequest(HttpServletRequest request, HttpServletResponse response, boolean isPost)
			throws IOException, ServletException {

		int cardId = Integer.parseInt(request.getParameter("cardId"));
		int userId = (int) request.getSession().getAttribute("userId");
		boolean isValid = (request.getParameter("cardId") != null);

		if (isValid) {
			String button = request.getParameter("button");
			if (!isPost) {
				CardDto cardSelected = this.cardservice.getCard(cardId);
				request.setAttribute("cardSelected", cardSelected);
				request.getRequestDispatcher("/write.jsp").forward(request, response);
			} else {
				String message = request.getParameter("message");
				String recipient = request.getParameter("recipient");
				String font = request.getParameter("font");

				try {
					CardDto card = this.cardservice.getCard(cardId);

					CardLetterDto newLetter = new CardLetterDto(0, userId, cardId, recipient, message, font,
							card.getPrice(), DateTime.GetCurrentDate()); // new letter
					newLetter = this.userservice.getUserLetter(userId,
							this.userservice.addUserLetter(userId, newLetter));
				} catch (Exception e) {
					this.context.log("Error on processing letter request: " + e.getMessage());
					response.sendError(cardId, "Unable to Process. Please see WriteServlet.java");
				} finally {
					this.userservice.saveChanges(); // save all if no errors;
				}
			}
			String URL = (button.contains("Pay") ? "/payment.jsp" : "/myaccount.jsp");
			request.getRequestDispatcher(URL).forward(request, response);
		}

		else {
			this.context.log("Cannot find card with ID: " + cardId);
			response.sendRedirect("/cards.jsp");
			return;
		}

	}// end of method

	/**
	 * @param request
	 * @param response
	 * @param isNew
	 * @throws ServletException
	 * @throws IOException
	 */
	private void proccesLetterRequest(HttpServletRequest request, HttpServletResponse response, boolean isNew,
			boolean isPost) throws ServletException, IOException {

		int letterId = Integer.parseInt(request.getParameter("letterId"));
		int userId = (int) request.getSession().getAttribute("userId");

		String URL = null;

		if (isPost) {
			String message = request.getParameter("message");
			String recipient = request.getParameter("recipient");
			String font = request.getParameter("font");
			String button = request.getParameter("button");
			if (message.isEmpty() && recipient.isEmpty()) {
				request.setAttribute("validationMessage", "<b>Invalid Message or Recipient!</b> Please try again.");
			} else {
				try {
					CardLetterDto oldLetter = this.userservice.getUserLetter(userId, letterId);
					oldLetter.setMessage(message);
					oldLetter.setRecipient(recipient);
					if (!this.userservice.updateUserLetter(userId, oldLetter)) {
						throw new Exception("Unable to Update letter for user.");
					}
				} catch (Exception e) {
					this.context.log("Error on processing letter request: " + e.getMessage());
					response.sendError(letterId, "Unable to Process. Please see WriteServlet.java");
					return;
				}
				this.userservice.saveChanges();
			}
			UserDto updatedUser = this.userservice.findUserById(userId);
			request.getSession().setAttribute("user", updatedUser);
			request.getRequestDispatcher("myaccount.jsp").forward(request, response);
		} else {
			CardLetterDto letter = this.userservice.getUserLetter(userId, letterId);
			if (letter == null) {
				this.context.log("Unable to find Letter with Id: " + letterId);
				response.sendRedirect("/cards.jsp");
			} else {
				CardDto card = this.cardservice.getCard(letter.getCardId());
				request.setAttribute("cardSelected", card);
				request.setAttribute("message", letter.getMessage());
				request.setAttribute("recipient", letter.getRecipient());
				request.setAttribute("letterId", letter.getId());
				request.getRequestDispatcher("write.jsp").forward(request, response);
			}
		}
	}// end of proccesLetterRequest

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.context = (ServletContext) config.getServletContext();
		this.cardservice = (CardService) config.getServletContext().getAttribute("cardService");
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
	}

}

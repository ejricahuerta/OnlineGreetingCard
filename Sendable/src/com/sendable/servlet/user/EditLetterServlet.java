package com.sendable.servlet.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;
import sendable.logic.services.CardService;
import sendable.logic.services.UserService;

/**
 * Servlet implementation class EditLetterServlet
 */
@WebServlet("/EditLetter")
public class EditLetterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ServletContext context;

	private UserService userservice;

	private CardService cardservice;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {			
			int letterId = Integer.parseInt(req.getParameter("letterId"));
			int userId = (int) req.getSession().getAttribute("userId");
			CardLetterDto letter = this.userservice.getUserLetter(userId, letterId);
			CardDto cardSelected = this.cardservice.getCard(letter.getCardId());
			if (letter != null && cardSelected != null) {

				req.setAttribute("cardSelected", cardSelected);
				req.setAttribute("letterId", letter.getId());
				req.setAttribute("message", letter.getMessage());
				req.setAttribute("recipient", letter.getRecipient());
				req.getRequestDispatcher("write.jsp").forward(req, resp);
			} 
			else {
				UserDto user  =this.userservice.findUserById(userId);
				req.setAttribute("user", user);
				req.getRequestDispatcher("myaccount.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			resp.sendRedirect("index.jsp");
		}

		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int userId = (int)req.getSession().getAttribute("userId");
		String message  = req.getParameter("message");
		String recipient = req.getParameter("recipient");
		int letterId = Integer.parseInt(req.getParameter("letterId"));
		CardLetterDto letter = this.userservice.getUserLetter(userId, letterId);
		boolean success = false;
		if(letter == null) {
			resp.sendRedirect("MyAccount");
		}
		else {
			letter.setMessage(message);
			letter.setRecipient(recipient);
		 success = this.userservice.updateUserLetter(userId, letter);
		 
		}
		if(success) {
			this.userservice.saveChanges();
			UserDto user  = this.userservice.findUserById(userId);
			req.setAttribute("type", "EditLetter");
			req.setAttribute("user", user);
			if(req.getParameter("button").contains("Save")) {
			resp.sendRedirect("MyAccount");
			}
			else {
				resp.sendRedirect("Payment?letterId=" + letterId);
			}
		}
		else {
			resp.sendRedirect("index.jsp");
		}
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.context = config.getServletContext();
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
		this.cardservice = (CardService) config.getServletContext().getAttribute("cardService");
	}

}

package com.sendable.servlet.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.logic.dtos.CardDto;
import sendable.logic.services.CardService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/Write")
public class WriteServlet extends HttpServlet {

	private CardService cardservice;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("cardId") == null) {
			response.sendRedirect("card.jsp");
		}

		String message = request.getParameter("message");
		if (message == null || message.length() < 5) {	
			request.setAttribute("validationMessage", "<b>Invalid Message!</b> Please Enter your message again.");
		
			CardDto card =  this.cardservice.getCard(Integer.parseInt(request.getParameter("cardId")));
			request.setAttribute("cardSelected", card);
			request.getRequestDispatcher("write.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("cardId") == null) {
			response.sendRedirect("card.jsp");
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
	}

}

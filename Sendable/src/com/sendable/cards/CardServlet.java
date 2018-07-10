package com.sendable.cards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.dao.entities.Category;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CategoryDto;
import sendable.logic.services.CardService;

@WebServlet("/Cards")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CardServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("search") == null) {
			response.sendRedirect("cards.jsp");
		} else {
			CardService service = (CardService) request.getServletContext().getAttribute("cardService");
			String filter = request.getParameter("search").toLowerCase().trim();
			List<CardDto> allcards = new ArrayList<CardDto>();
			switch (filter) {
			case "brithdays":
				allcards = service.ListCardsByCategory(1);
				break;
			case "aniversaries":
				allcards = service.ListCardsByCategory(2);
				break;
			case "christmas":
				allcards = service.ListCardsByCategory(3);
				break;
			case "valentines":
				allcards = service.ListCardsByCategory(4);
				break;
			default:
				for (CardDto c : service.ListCards()) {
					if (c.getName().contains(filter.toLowerCase()) || c.getDescription().contains(filter)
							|| c.getImageURL().contains(filter)) {
						if (!allcards.contains(c)) {
							allcards.add(c);
						}
						if (service.GetCategoryByCard(c.getId()).getName().contains(filter)) {
							if (!allcards.contains(c)) {
								allcards.add(c);
							}
						}
					}
				}
				break;
			}
			request.setAttribute("allcards", allcards);
			request.getRequestDispatcher("cards.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("cards.jsp");
	}
}

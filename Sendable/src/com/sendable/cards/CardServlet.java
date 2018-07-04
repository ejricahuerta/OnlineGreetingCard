package com.sendable.cards;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.logic.services.CardService;


@WebServlet("/Card")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CardServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		CardService service =  (CardService)request.getServletContext().getAttribute("cardService");
		 
		
		request.setAttribute("allcategories", service.ListCards());
		
		
		out.println(String.format( "AllCategories Count : %.2f" , service.ListCards().size()));
		
	}
}

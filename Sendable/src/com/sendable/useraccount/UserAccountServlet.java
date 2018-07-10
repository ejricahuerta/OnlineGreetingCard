package com.sendable.useraccount;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sendable.logic.dtos.UserDto;
import sendable.logic.services.UserService;

/**
 * Servlet implementation class UserAccountServlet
 */
@WebServlet("/MyAccount")
public class UserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession(false);
		int id = (int) session.getAttribute("userId");
		System.out.println("ID: "+ id);
		UserService service = (UserService) session.getServletContext().getAttribute("userService");
		UserDto user = service.FindUserById(id);
		
		if(user==null) {
			response.sendRedirect("index.jsp");
		}
		
		System.out.println("Current User Email: " + user.getEmail());
		session.setAttribute("user", user);
		response.sendRedirect("myaccount.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}

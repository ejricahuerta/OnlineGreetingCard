package com.sendable.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.mock.MockService;
import sendable.dao.entities.User;
import sendable.logic.dtos.UserDto;
import sendable.logic.services.UserService;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		System.out.println(email);
		String password = request.getParameter("password");
		System.out.println(password);
		String error = "<b>Invalid Login!</b> Please Try Again.";
		UserService service = (UserService) request.getServletContext().getAttribute("userService");
		
		if (service.ValidateLogin(email, password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", email);
			UserDto userfound = service.FindUserByEmail(email);
			System.out.println(userfound.getCurrentAddress());
			session.setAttribute("UserInfo", userfound);
			response.sendRedirect("index.jsp");
		}
		request.setAttribute("validationMessage", error);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
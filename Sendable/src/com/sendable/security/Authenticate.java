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

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Login")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authenticate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("Authenticate/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("username") != null) {
			response.sendRedirect("index.jsp");
		} else {
			MockService seed = new MockService();
			HttpSession session = request.getSession(true);

			if (session.getServletContext().getAttribute("seedusers") == null) {
				session.getServletContext().setAttribute("seedusers", seed);
			}

			User temp = new User(request.getParameter("email"), request.getParameter("password"));

			System.out.println("Current Logged In User...");
			System.out.println(String.format("Email: %s", temp.getEmail()));
			System.out.println(String.format("Password ", temp.getPassword()));
			for (User user : seed.AllUsers()) {
				if (user.getEmail().equals(temp.getEmail()) && user.getPassword().equals(temp.getPassword())) {
					session.setAttribute("username", temp.getEmail());
					response.addCookie(new Cookie("user", temp.getEmail()));
					response.sendRedirect("index.jsp");
				}
			}
			request.setAttribute("validationMessage", "<b>Invalid Login!</b> Please try again.");
			request.getRequestDispatcher("Authenticate/login.jsp").include(request, response);
		}
	}
}
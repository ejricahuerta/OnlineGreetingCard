package com.pro684.sendable.secure;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.mock.MockService;
import sendable.entities.Address;
import sendable.entities.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameterNames().hasMoreElements()) {

			HttpSession session = request.getSession(false);
			
			if (session.getServletContext().getAttribute("seedusers") == null) {
				MockService seed = new MockService();
				session.getServletContext().setAttribute("seedusers", seed);
			}

			if (!request.getParameter("password").equals(request.getParameter("retypepassword"))) {
				request.removeAttribute("validationMessage");
				request.setAttribute("validationMessage", "Password Did not Match!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
		response.sendRedirect("register.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void printUsers(MockService newseed) {
		for (User user : newseed.AllUsers()) {
			System.out.println(user.getEmail());
		}
	}
}

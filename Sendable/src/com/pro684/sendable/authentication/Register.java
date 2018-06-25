package com.pro684.sendable.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro684.sendable.entities.Address;
import com.pro684.sendable.entities.User;

import data.seed.Seed;

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

		HttpSession session = request.getSession(true);

		if (session.getServletContext().getAttribute("seedusers") == null) {
			Seed seed = new Seed();
			session.getServletContext().setAttribute("seedusers", seed);
		}

		for (User user : ((Seed) session.getServletContext().getAttribute("seedusers")).AllUsers()) {
			if (user.getEmail().equals(request.getParameter("email"))) {
				request.removeAttribute("validationMessage");
				request.setAttribute("validationMessage", "<b>Email Exists!</b> Go to Login Page.");
				request.getRequestDispatcher("register.jsp").forward(request, response);

				break;

			}
			return;
		}
		if (!request.getParameter("password").equals(request.getParameter("retypepassword"))) {
			request.removeAttribute("validationMessage");
			request.setAttribute("validationMessage", "Password Did not Match!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		Address addressforUser = new Address(request.getParameter("line1"), request.getParameter("line2"),
				request.getParameter("city"), request.getParameter("state"), request.getParameter("postalcode"));

		if (!addressforUser.Isvalid()) {

			request.removeAttribute("validationMessage");
			request.setAttribute("validationMessage", "<b>Address not Found!</b> Please enter valid Address.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		
		String name = String.format("%s %s", request.getParameter("firstname"), request.getParameter("lastname"));
		User newUser = new User(name, request.getParameter("email"), request.getParameter("password"), addressforUser);
		
		Seed reseed = ((Seed)request.getServletContext().getAttribute("seeduser"));
		reseed.AddUser(newUser);
		request.removeAttribute("seedusers");
		request.setAttribute("seedusers", reseed);
		response.sendRedirect("login.jsp");
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

}

package com.pro684.sendable.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import com.pro684.sendable.entities.User;

import data.seed.Seed;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
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
		
		Seed seed = new Seed();
		
		HttpSession session = request.getSession(true);
		
		
		if( session.getServletContext().getAttribute("seedusers") == null){
			session.getServletContext().setAttribute("seedusers", seed);
		}
		
		
		User temp = new User(request.getParameter("email"), request.getParameter("password"));
		
		System.out.println(temp.getEmail());
		System.out.println(temp.getPassword());
		
		for (User user : seed.AllUsers()) {
			if (user.getEmail().equals(temp.getEmail()) && user.getPassword().equals(temp.getPassword())) {

				session.setAttribute("username", user.getEmail());
				response.sendRedirect("index.jsp");
				return;
				
			} else {
				
				request.setAttribute("validationMessage", "<big>Invalid Login!</big> Please try again.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

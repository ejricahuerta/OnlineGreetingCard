package com.pro684.sendable.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Seed seed = new Seed();
		HttpSession session = request.getSession(true);		
		if(request.getParameter("password").equals(request.getParameter("retypepassword"))) {
			
			request.setAttribute("validationMessage", "Password Did not Match!");
			request.getRequestDispatcher("register.jsp").forward(request, response);			
		}
				
		if( session.getServletContext().getAttribute("seedusers") == null){
		
			session.getServletContext().setAttribute("seedusers", seed);
		}
		
		User newUser = new User();
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword("password");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

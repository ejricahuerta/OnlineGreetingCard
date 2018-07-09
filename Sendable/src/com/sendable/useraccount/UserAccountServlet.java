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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) request.getSession();
		UserService service =  (UserService)session.getAttribute("userService");
		
		String email = (String)session.getAttribute("userEmail");
		if(email == null) {
			response.sendRedirect("index.jsp");
		}
		else {
		UserDto user = service.FindUserByEmail(email);
		System.out.println("Current User Email: " + user.getEmail());
		session.setAttribute("user", user);
		response.sendRedirect("myaccount.jsp");	
		}
	}
}

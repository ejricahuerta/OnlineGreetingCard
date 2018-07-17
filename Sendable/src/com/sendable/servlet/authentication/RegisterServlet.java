package com.sendable.servlet.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.UserDto;
import sendable.logic.services.UserService;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!request.getParameterNames().hasMoreElements()) {
			response.sendRedirect("register.jsp");
		}
		UserService service = (UserService) request.getServletContext().getAttribute("userService");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String line1 = request.getParameter("line1");
		String line2 = request.getParameter("line2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalcode = request.getParameter("postalcode");
		
		if (!request.getParameter("password").equals(request.getParameter("retypepassword"))) {
			request.setAttribute("validationMessage", "Password Did not Match!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if (service.isUserFound(email)) {
			request.setAttribute("validationMessage", "Email Exist! Please go and Login");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} 
		else {
			try {
				
				UserDto newUser = new UserDto(0, fname+ " " +lname ,
						email, 
						request.getParameter("password"), 
						phone, postalcode, null, null, postalcode, null);
				AddressDto address = new AddressDto(0, line1,line2, city, state,postalcode);
				service.addNewUser(newUser, address);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(5*60);
			Cookie cookie = new Cookie("email", email);
			UserDto userDto = service.findUserByEmail(email);
			System.out.println("USER ID: "+userDto.getId());
			session.setAttribute("userId", userDto.getId());
			session.setAttribute("userEmail",userDto.getEmail());
			response.addCookie(cookie);
			response.sendRedirect("index.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

}

package com.sendable.servlet.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
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
	
	private UserService service;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String email  = (String)request.getSession().getAttribute("userEmail");
		System.out.println("Email: " + email);
		UserDto user = service.findUserByEmail(email);
		if (user == null) {
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("Current User Email: " + user.getEmail());
			request.setAttribute("user", user);
			request.getRequestDispatcher("myaccount.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession();
		int Id = (int) session.getAttribute("userId");
		String modalType = request.getParameter("editmodal");
		if(modalType.isEmpty()) {
			this.doGet(request, response);
		}		
		else {
			String email = (String)session.getAttribute("userEmail");
			// validate user password
			String password = request.getParameter("currentpassword");
			boolean validUser = service.validateLogin(email, password);
			boolean success = false;
			if (validUser) {
				// Edit Modal Type
				UserDto user = this.service.findUserById(Id);
				switch (modalType) {
				
				case "fullname": // edit for full name
					String fname = request.getParameter("firstname");
					String lname = request.getParameter("lastname");
					success = service.updateUserInfo(Id, fname, lname, user.getEmail(), user.getPhone());
					break;

				case "phone": //edit phone
					String phone = request.getParameter("phone");
					success = service.updateUserInfo(Id, 
							user.getFullName().split(" ")[0], 
							user.getFullName().split(" ")[1], 
							user.getEmail(), phone);
					break;
				
				case "address": // edit for address

					String line1 = request.getParameter("line1");
					String line2 = request.getParameter("line2");
					String city = request.getParameter("city");
					String state = request.getParameter("state");
					String postalcode = request.getParameter("postalcode");
					success = service.updateUserAddress(Id, line1, line2, city, state, postalcode);
					break;
					
				case "password":
					
					String newpassword = request.getParameter("newpassword");
					String retypepassword  = request.getParameter("retypepassword");					
					success = (newpassword.equals(retypepassword) && !newpassword.isEmpty() && newpassword.length() > 5?this.service.changeUserPassword(Id, newpassword): false);
					break;
					
				default: // nothing then returns to page
					this.doGet(request, response);
					break;
				}
				
				if (success) { // Saves all changes
					service.saveChanges();
					
					System.out.println("Saved Changes");
					UserDto updatedUser = service.findUserById(Id);
					request.setAttribute("user", updatedUser);
				}
			}
			else {
				request.setAttribute("validationMessage", "<b>Update  Failed!</b> Unable to Process Update.");
			}
			request.getRequestDispatcher("myaccount.jsp").forward(request, response);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.service = (UserService) config.getServletContext().getAttribute("userService");
	}

}

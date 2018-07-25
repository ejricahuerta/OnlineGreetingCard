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
	
	private UserService userservice;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = (HttpSession) request.getSession(false);
		int id = (int) session.getAttribute("userId");
		System.out.println("ID: " + id);
		UserDto user = this.userservice.findUserById(id);
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
			boolean validUser = userservice.validateLogin(email, password);
			boolean success = false;
			if (validUser) {
				// Edit Modal Type
				UserDto user = this.userservice.findUserById(Id);
				switch (modalType) {
				
				case "fullname": // edit for full name
					String fname = request.getParameter("firstname");
					String lname = request.getParameter("lastname");
					success = userservice.updateUserInfo(Id, fname, lname, user.getEmail(), user.getPhone());
					break;

				case "phone": //edit phone
					String phone = request.getParameter("phone");
					success = userservice.updateUserInfo(Id, 
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
					success = userservice.updateUserAddress(Id, line1, line2, city, state, postalcode);
					break;
					
				case "password":
					
					String newpassword = request.getParameter("newpassword");
					String retypepassword  = request.getParameter("retypepassword");
					
					success = (newpassword.equals(retypepassword) && !newpassword.isEmpty() && newpassword.length() > 5?this.userservice.changeUserPassword(Id, newpassword): false);
					break;
					
				case "topup":
					
					double amount = Double.parseDouble(request.getParameter("topupamount"));
					success =  this.userservice.topUpUserAccount(Id, amount);
					
					break;
				default:
					break;
				}
				
				if (success) { // Saves all changes
					userservice.saveChanges();
					System.out.println("Saved Changes");
				response.sendRedirect("MyAccount");
				}
			}
			else {
				request.setAttribute("validationMessage", "<b>Update  Failed!</b> Unable to Process Update.");
				this.doGet(request, response);
			}
		}
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
	}

}

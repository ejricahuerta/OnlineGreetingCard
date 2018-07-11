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
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession(false);
		int id = (int) session.getAttribute("userId");
		System.out.println("ID: " + id);
		UserService service = (UserService) session.getServletContext().getAttribute("userService");
		UserDto user = service.FindUserById(id);

		if (user == null) {

			response.sendRedirect("index.jsp");
		} else {
			System.out.println("Current User Email: " + user.getEmail());
			session.setAttribute("user", user);
			response.sendRedirect("myaccount.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		int Id = (int) session.getAttribute("userId");
		String modalType = request.getParameter("editmodal");
		if (modalType.isEmpty()) {
			this.doGet(request, response);
		} else {

			// validate user password
			String password = request.getParameter("currentpassword");
			boolean validUser = userservice.ValidateLogin(user.getEmail(), password);
			boolean success= false;
			if (validUser) {
				// Edit Modal Type
				switch (modalType) {
				case "fullname": // edit for fullname
					String fname = request.getParameter("firstname");
					String lname = request.getParameter("lastname");
					success = userservice.UpdateUserInfo(Id, fname, lname, user.getEmail());
					break;
				case "address": // edit for address
					break;
				default: // nothing then returns to page
					this.doGet(request, response);
					break;
				}
			}
			if (success) {
				userservice.SaveChanges();
				System.out.println("Saved Changes");
				UserDto updatedUser = userservice.FindUserById(Id);
				session.setAttribute("user", updatedUser);
			} else {
				request.setAttribute("validationMessage", "<b>Update Failed!</b> Unable to Process Update.");
			}
			request.getRequestDispatcher("myaccount.jsp").forward(request, response);
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
	}

}

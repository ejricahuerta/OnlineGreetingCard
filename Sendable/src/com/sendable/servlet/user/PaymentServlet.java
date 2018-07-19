package com.sendable.servlet.user;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;
import sendable.logic.services.PaymentService;
import sendable.logic.services.UserService;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet(description = "Payment Servlet for User", urlPatterns = { "/Payment" })
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PaymentService paymentservice;

	private UserService userservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.paymentservice = (PaymentService) config.getServletContext().getAttribute("paymentService");
		this.userservice = (UserService) config.getServletContext().getAttribute("userService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int letterId = Integer.parseInt(request.getParameter("letterId"));
		int userId = (int) request.getSession().getAttribute("userId");
		CardLetterDto letter = this.userservice.getUserLetter(userId, letterId);
		request.setAttribute("letter", letter);
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String letterId = request.getParameter("letterId");
		double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
		int userId = (int) request.getSession().getAttribute("userId");

		if (letterId == null || totalAmount < 0 || this.userservice.findUserById(userId) == null) {
			response.sendRedirect("index.jsp");
		} else {

			String line1 = request.getParameter("line1");
			String line2 = request.getParameter("line2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String postalcode = request.getParameter("postalcode");
			String paymentType = request.getParameter("paymentType");

			if (line1.isEmpty() || city.isEmpty() || state.isEmpty() || postalcode.isEmpty()) {
				request.setAttribute("validationMessage", "<b>Invalid Address!</b> Please try again.");
				request.getRequestDispatcher("pay.jsp").forward(request, response);
			} else {
				AddressDto shipping = new AddressDto(0, line1, line2, city, state, postalcode);
			 boolean success = this.paymentservice.MakePaymentByAccount(userId, Integer.parseInt(letterId), paymentType, totalAmount, shipping);
			 
			 if(success) {
				 this.userservice.saveChanges();
			 }
			 	UserDto  user =  this.userservice.findUserById(userId);
				request.setAttribute("user", user);
				request.getRequestDispatcher("myaccount.jsp").forward(request, response);
			}
		} 

	}

}

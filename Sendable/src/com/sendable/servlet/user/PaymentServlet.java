package com.sendable.servlet.user;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendable.logic.dtos.CardLetterDto;
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
		this.paymentservice = (PaymentService)config.getServletContext().getAttribute("paymentService");
		this.userservice = (UserService)config.getServletContext().getAttribute("userService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int letterId  = Integer.parseInt(request.getParameter("letterId"));	
		int userId = (int)request.getSession().getAttribute("userId");
		CardLetterDto letter = this.userservice.getUserLetter(userId, letterId);
		request.setAttribute("letter", letter);
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.easy_kiosk.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentMethodC")
public class PaymentMethodC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * if(request.getParameter("savePoint") != null){
		 * EasyDAO.getEasyDAO().savePoint(request); }
		 */
		EasyDAO.getEasyDAO().savePoint(request); // 포인트 적립
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "payment/payment_method.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String card = request.getParameter("card");
		String cash = request.getParameter("cash");

		System.out.println("Card : " + card);
		System.out.println("Cash : " + cash);
		
		if (card != null) {
			request.getRequestDispatcher("jsp/payment/payment_card.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("jsp/payment/payment_cash.jsp").forward(request, response);
		}
	}

}

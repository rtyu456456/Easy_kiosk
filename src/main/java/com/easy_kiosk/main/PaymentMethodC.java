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

		if(request.getParameter("savePoint") != null){
		EasyDAO.getEasyDAO().savePoint(request);
		}
		request.getRequestDispatcher("jsp/payment/payment_method.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String card = request.getParameter("card");
		String cash = request.getParameter("cash");
		String qr = request.getParameter("qr");

		System.out.println("Card : " + card);
		System.out.println("Cash : " + cash);
		System.out.println("QR : " + qr);
		
		if (card != null) {
			request.getRequestDispatcher("jsp/payment/payment_card.jsp").forward(request, response);
		} else if (cash != null) {
			request.getRequestDispatcher("jsp/payment/payment_cash.jsp").forward(request, response);
		} else if (qr != null) {
			request.getRequestDispatcher("jsp/payment/payment_qr.jsp").forward(request, response);
		}
	}

}

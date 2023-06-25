package com.easy_kiosk.kimoon;

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
		if(request.getParameter("savePoint") != null){ // 포인트 적립시에만
			EasyDAO.getEasyDAO().savePointForView(request); // 포인트 적립(DB적용X, 예상 수치 보여주기만)
		}
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../payment/payment_method.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String card = request.getParameter("card");
		String cash = request.getParameter("cash");

		System.out.println("Card : " + card);
		System.out.println("Cash : " + cash);
		
		if (card != null) {
			request.setAttribute("nav", "nav.jsp");
			request.setAttribute("contentPage", "../payment/payment_card.jsp");
			request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
		} else {
			request.setAttribute("nav", "nav.jsp");
			request.setAttribute("contentPage", "../payment/payment_cash.jsp");
			request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
		}
	}

}

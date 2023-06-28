package com.easy_kiosk.kimoon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PaymentMethodC")
public class PaymentMethodC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("savePoint") != null){ // 포인트 적립시에만
			EasyDAO.getEasyDAO().savePointForView(request); // 포인트 적립(DB적용X, 예상 수치 보여주기만)
		} else {
			EasyDAO.getEasyDAO().resetHowPoint(request); // payment_method.jsp로 가기 전에 howPoint 세션 삭제
		}
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../payment/payment_method.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EasyDAO.getEasyDAO().howPayment(request);
		HttpSession session = request.getSession();
		String howPayment = (String) session.getAttribute("howPayment");

		System.out.println("payment : " + howPayment);

		
		if (howPayment.equals("card")) {
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

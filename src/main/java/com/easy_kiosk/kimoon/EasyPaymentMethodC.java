package com.easy_kiosk.kimoon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EasyPaymentMethodC")
public class EasyPaymentMethodC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EasyDAO.getEasyDAO().EasyjsonToURL(request);
		
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../payment/payment_method.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

package com.easy_kiosk.kimoon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/OrderTypeC")
public class OrderTypeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = EasyDAO.getEasyDAO().orderType(request);
		request.setAttribute("nav", "nav.jsp");
		if (session.getAttribute("orderType").equals("normalOrder")) {
			request.getRequestDispatcher("GeneralOrderHomeCon").forward(request, response);
		} else {
			request.setAttribute("contentPage", "simple_order.jsp");
			request.getRequestDispatcher("EasyMenuController").forward(request, response);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

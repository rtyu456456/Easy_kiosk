package com.easy_kiosk.kimoon;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EarnPointC")
public class EarnPointC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EasyDAO.getEasyDAO().easyPay(request);
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../point/point_confirm.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../point/point_pressnum.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}

}

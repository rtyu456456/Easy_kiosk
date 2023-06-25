package com.easy_kiosk.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EarnPointC")
public class EarnPointC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "point/point_confirm.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "point/point_pressnum.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}

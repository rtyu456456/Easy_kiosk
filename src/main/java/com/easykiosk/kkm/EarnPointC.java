package com.easykiosk.kkm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EarnPointC")
public class EarnPointC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/earn_point_pressnum.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// EasyDAO.getNum(request);
		EasyDAO.getCustomer(request);
		request.getRequestDispatcher("jsp/earn_point_usepoint.jsp").forward(request, response);
	}

}

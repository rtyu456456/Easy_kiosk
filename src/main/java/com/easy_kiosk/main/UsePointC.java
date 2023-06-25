package com.easy_kiosk.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsePointC")
public class UsePointC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EasyDAO.getEasyDAO().getCustomer(request); // 고객 정보 조회
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../point/point_selectpoint.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EasyDAO.getEasyDAO().usePointForView(request); // 포인트 사용(DB적용X, 예상 수치 보여주기만)
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "../payment/payment_method.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}

}

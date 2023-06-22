package com.easy_kiosk.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ResultC")
public class ResultC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EasyDAO.getEasyDAO().orderNum(request); // 주문번호 계산
		HttpSession session = request.getSession();
		String howPoint = (String) session.getAttribute("howPoint");
		if (session.getAttribute(howPoint)=="usePoint") { // 포인트 사용시
			EasyDAO.getEasyDAO().usePoint(request); // 카드 결제 끝나면 실제로 DB에 적용
		} else { // 포인트 적립시
			EasyDAO.getEasyDAO().savePoint(request); // 카드 결제 끝나면 실제로 DB에 적용
		}
		request.getRequestDispatcher("jsp/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

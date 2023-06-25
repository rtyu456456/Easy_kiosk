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
		System.out.println(howPoint);
		if (howPoint == null) {
			System.out.println("간편결제");
		} else if (howPoint.equals("usePoint")) { // 포인트 사용시
			System.out.println("포인트 사용 메소드 호출 성공");
			EasyDAO.getEasyDAO().usePoint(request); // 결제 끝나면 실제로 DB에 적용
		} else if(howPoint.equals("savePoint")) { // 포인트 적립시(그냥 else로 적으면 간편 주문시 터짐)
			EasyDAO.getEasyDAO().savePoint(request); // 결제 끝나면 실제로 DB에 적용
		}
		
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "result.jsp");
		request.getRequestDispatcher("jsp/kimoon/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

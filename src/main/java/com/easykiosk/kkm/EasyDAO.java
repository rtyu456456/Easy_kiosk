package com.easykiosk.kkm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EasyDAO {

	public static void whereToEat(HttpServletRequest request) {
		String whereToEat = request.getParameter("whereToEat"); // 클라이언트가 선택한 버튼의 값 가져오기
		HttpSession session = request.getSession(); // 세션 생성 또는 기존 세션 가져오기
		session.setAttribute("whereToEat", whereToEat); // 세션에 선택한 주문 유형 저장
	}

	public static HttpSession orderType(HttpServletRequest request) {
		String orderType = request.getParameter("orderType");
		HttpSession session = request.getSession(false); // request의 getSession()메서드의 피라미터로 false를 전달하면 이미 생성된 세션이 있을 때 그 세션을 반환하고 없으면 null을 반환한다.
		session.setAttribute("orderType", orderType);
		return session;
	}
	
	
	
}

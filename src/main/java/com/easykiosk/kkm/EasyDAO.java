package com.easykiosk.kkm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class EasyDAO {

	public static void whereToEat(HttpServletRequest request) {
		String whereToEat = request.getParameter("whereToEat"); // 클라이언트가 선택한 버튼의 값 가져오기
		HttpSession session = request.getSession(); // 세션 생성 또는 기존 세션 가져오기
		session.setAttribute("whereToEat", whereToEat); // 세션에 선택한 주문 유형 저장
	}

	public static HttpSession orderType(HttpServletRequest request) {
		String orderType = request.getParameter("orderType");
		HttpSession session = request.getSession(false); // request의 getSession()메서드의 피라미터로 false를 전달하면 이미 생성된 세션이 있을 때
															// 그 세션을 반환하고 없으면 null을 반환한다.
		session.setAttribute("orderType", orderType);
		return session;
	}

	public static HttpSession getNum(HttpServletRequest request) {
		String phoneNumber = request.getParameter("phoneNumber");
		HttpSession session = request.getSession(false);
		session.setAttribute("phoneNumber", phoneNumber);
		return session;
	}

	public static void getCustomer(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String phoneNumber = (String) request.getSession().getAttribute("phoneNumber");
		int point = 500;
		String sql = "select * from EK_USER where u_no = ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "update EK_USER set u_point = ? + ? where u_no = ?";
				pstmt.setInt(1, point);
				pstmt.setInt(2, 300);
				pstmt.setString(3, phoneNumber);
			} else {
				sql = "insert into EK_USER values(?, ?)";
				pstmt.setString(1, phoneNumber);
				pstmt.setInt(2, point);
			}
			User user = new User();
			user.setPhoneNumber(rs.getString(phoneNumber));
			user.setPoint(rs.getInt(point));
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void UsePoint(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, null, null);
		}
	}

}

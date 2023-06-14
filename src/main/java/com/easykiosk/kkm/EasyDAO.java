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
		HttpSession session = request.getSession(false); // request의 getSession()메서드의 피라미터로 false를 전달하면 이미 생성된 세션이 있을 때
															// 그 세션을 반환하고 없으면 null을 반환한다.
		session.setAttribute("orderType", orderType);
		return session;
	}

	public static HttpSession getNum(HttpServletRequest request) {
		String phoneNumber = request.getParameter("phoneNumber");
		HttpSession session = request.getSession();
		session.setAttribute("phoneNumber", phoneNumber);
		return session;
	}

	public static void getCustomer(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String phoneNumber = (String) request.getSession().getAttribute("phoneNumber");
		int point = 500;
		String sql1 = "select * from EK_USER where u_no = ?";

		try {
			con = DBManager.connect();
			System.out.println("연결 성공!");
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sql2 = "update EK_USER set u_point = ? + ? where u_no = ?";
				pstmt.close();
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, point);
				pstmt.setInt(2, 300);
				pstmt.setString(3, phoneNumber);
				pstmt.executeUpdate();
			} else {
				String sql3 = "insert into EK_USER values(?, ?)";
				rs.close();
				pstmt.close();
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, phoneNumber);
				pstmt.setInt(2, point);
				pstmt.executeUpdate();
				pstmt.close();
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, phoneNumber);
				rs = pstmt.executeQuery();
				rs.next();
			}
			User user = new User();
			user.setPhoneNumber(rs.getString("u_no"));
			user.setPoint(rs.getInt("u_point"));
			System.out.println(user.toString());
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

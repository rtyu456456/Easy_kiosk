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

	public static void getCustomer(HttpServletRequest request) { // 고객의 번호와 포인트 update 또는 insert
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String phoneNumber = request.getParameter("phoneNumber"); // input 안의 값
		int point = 500; // 받은 포인트
		String sql_select = "select * from EK_USER where u_no = ?";

		try {
			con = DBManager.connect();
			System.out.println("연결 성공!");
			pstmt = con.prepareStatement(sql_select);
			pstmt.setString(1, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sql_update = "update EK_USER set u_point = ? + ? where u_no = ?"; // 기존의 유저일 경우
				int userPoint = rs.getInt("u_point"); // 유저의 현재 포인트
				pstmt.close(); // 위에서 사용한 pstmt는 닫고서 다시 사용해야함
				pstmt = con.prepareStatement(sql_update);
				pstmt.setInt(1, userPoint); // pstmt.setInt(1, rs.getInt("u_point")); 로 할 경우 윗줄에서 pstmt.close()가 됐기 때문에 rs의 값을 받아올 수 없음
				pstmt.setInt(2, 1000); // 1000원 추가
				pstmt.setString(3, phoneNumber);
				pstmt.executeUpdate();
				rs.close();
				pstmt.close();
				pstmt = con.prepareStatement(sql_select); // 아래 User에 담아주기 위해서 다시 select로 조회
				pstmt.setString(1, phoneNumber);
				rs = pstmt.executeQuery();
				rs.next();
			} else {
				String sql_insert = "insert into EK_USER values(?, ?)"; // 새로 등록한 유저일 경우
				rs.close(); // 위에서 사용한 rs는 닫고서 다시 사용해야함
				pstmt.close();
				pstmt = con.prepareStatement(sql_insert);
				pstmt.setString(1, phoneNumber);
				pstmt.setInt(2, point); // 500원 추가
				pstmt.executeUpdate(); // executeUpdate 까먹지 말기
				pstmt.close();
				pstmt = con.prepareStatement(sql_select);
				pstmt.setString(1, phoneNumber);
				rs = pstmt.executeQuery();
				rs.next();
			}
			User user = new User();
			user.setPhoneNumber(rs.getString("u_no")); // rs.getString에는 변수가 아니라 "DB내용"
			user.setPoint(rs.getInt("u_point"));
			System.out.println(user.toString());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void remainPoint(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = (User) request.getSession().getAttribute("user"); // user bean값을 다시 User user에 담아서 getPoint를 사용할 수 있게 함
		String userNo = user.getPhoneNumber();
		int userPoint = user.getPoint(); // 현재 포인트
		int remainPoint = 0; // 남은 포인트
		int totalPrice = 6000; // 총 구매 가격
		int finalPrice = 0; // 최종 결제 가격
		String sql = "update EK_USER set u_point = ? where u_no = ?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			if (userPoint >= totalPrice) {
				finalPrice = 0;
				remainPoint = userPoint - totalPrice;
			} else {
				finalPrice = totalPrice - userPoint;
				remainPoint = 0;
			}
			pstmt.setInt(1, remainPoint);
			pstmt.setString(2, userNo);
			if (pstmt.executeUpdate() == 1) {
				user.setPoint(remainPoint);
				user.setFinalPrice(finalPrice);
				System.out.println(user.getPhoneNumber());
				System.out.println(user.getPoint());
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	
	//if 현재 포인트 >= 총 구매가격
	//결제되는 가격 = 0원
	//남은 포인트 = 현재 포인트 - 총 구매 가격
	//(else)if 현재 포인트 < 총 구매가격
	//결제되는 가격 = 총 구매가격 - 현재 포인트
	//남은 포인트 = 0원


}

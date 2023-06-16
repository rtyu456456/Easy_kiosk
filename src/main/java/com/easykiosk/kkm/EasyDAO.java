package com.easykiosk.kkm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EasyDAO {

	public static void whereToEat(HttpServletRequest request) {
		String whereToEat = request.getParameter("whereToEat"); // 클라이언트가 선택한 버튼의 값 가져오기
		HttpSession session = request.getSession();
		session.setAttribute("whereToEat", whereToEat); // 세션에 선택한 주문 유형 저장
	}

	public static HttpSession orderType(HttpServletRequest request) {
		String orderType = request.getParameter("orderType");
		HttpSession session = request.getSession(); 
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
		int point = 500; // 최초 회원 등록시 받는 포인트
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
				pstmt.setInt(1, userPoint); // pstmt.setInt(1, rs.getInt("u_point")); 로 할 경우 윗줄에서 pstmt.close()가 됐기 때문에
											// rs의 값을 받아올 수 없음
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
				pstmt.setInt(2, point); // 500원 추가(임의값)
				pstmt.executeUpdate(); // executeUpdate 까먹지 말기
				pstmt.close();
				pstmt = con.prepareStatement(sql_select);
				pstmt.setString(1, phoneNumber);
				rs = pstmt.executeQuery();
				rs.next();
			}
			User user = new User();
			user.setPhoneNumber(rs.getString("u_no")); // rs.getString에는 변수가 아니라 "DB내용"
			user.setSavingPoint(rs.getInt("u_point"));
			System.out.println("toString : " + user.toString());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void usePoint(HttpServletRequest request) { // 일반 주문시 사용되는 메소드
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = (User) request.getSession().getAttribute("user"); // user bean값을 다시 User user에 담아서 getPoint를 사용할 수 있게 함
		String userNo = user.getPhoneNumber();
		int savingPoint = user.getSavingPoint(); // 현재 포인트
		int usedPoint = 0; // 사용할 포인트
		int remainPoint = 0; // 남은 포인트
		int totalPrice = 6000; // 총 구매 가격
		int finalPrice = 0; // 최종 결제 가격
		String sql = "update EK_USER set u_point = ? where u_no = ?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			// if 현재 포인트 >= 총 구매가격
			// 사용할 포인트 = 총 구매가격
			// 결제되는 가격 = 0원
			// 남은 포인트 = 현재 포인트 - 총 구매 가격
			// else(if 현재 포인트 < 총 구매가격)
			// 사용할 포인트 = 현재 포인트
			// 결제되는 가격 = 총 구매가격 - 현재 포인트
			// 남은 포인트 = 0원
			if (savingPoint >= totalPrice) {
				usedPoint = totalPrice;
				finalPrice = 0;
				remainPoint = savingPoint - totalPrice;
			} else {
				usedPoint = savingPoint;
				finalPrice = totalPrice - usedPoint;
				remainPoint = 0;
			}
			pstmt.setInt(1, remainPoint);
			pstmt.setString(2, userNo);
			if (pstmt.executeUpdate() == 1) {
				user.setSavingPoint(savingPoint);
				user.setUsedPoint(usedPoint);
				user.setRemainPoint(remainPoint);
				user.setTotalPrice(totalPrice);
				user.setFinalPrice(finalPrice);
				System.out.println("getPhoneNumber : " + user.getPhoneNumber());
				System.out.println("getSavingPoint : " +user.getSavingPoint());
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				String usePoint = request.getParameter("usePoint");
				System.out.println("howPoint : " + request.getParameter("usePoint"));
				System.out.println("===============>>>>>>>>>>");
				session.setAttribute("howPoint", usePoint);
				System.out.println("===============>>>>>>>>>>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void notUsePoint(HttpServletRequest request) { // 포인트 사용 안 하고 적립만 할 경우
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = (User) request.getSession().getAttribute("user");
		String userNo = user.getPhoneNumber();
		int savingPoint = user.getSavingPoint(); // 현재 포인트
		int usedPoint = 0; // 사용할 포인트
		int remainPoint = 0; // 남은 포인트
		int totalPrice = 6000; // 총 구매 가격
		int finalPrice = 0; // 최종 결제 가격
		String sql = "update EK_USER set u_point = ? where u_no = ?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			remainPoint = (int) (totalPrice * 0.1 + savingPoint); // 남은 포인트 = 총 구매 가격 * 0.1 + 현재 포인트
			finalPrice = totalPrice; // 최종 결제 가격 = 총 구매 가격(할인이 없기 때문)
			pstmt.setInt(1, remainPoint);
			pstmt.setString(2, userNo);
			if (pstmt.executeUpdate() == 1) {
				user.setSavingPoint(savingPoint);
				user.setUsedPoint(usedPoint);
				user.setRemainPoint(remainPoint);
				user.setFinalPrice(finalPrice);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				String notUsePoint = request.getParameter("notUsePoint");
				System.out.println("howPoint : " + request.getParameter("notUsePoint"));
				session.setAttribute("howPoint", notUsePoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void resetSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
//		session.setAttribute("howPoint", null);
//		session.setAttribute("user", null);
//		session.setAttribute("phoneNumber", null);
		session.invalidate();
	}

}
		//결과창에서 쓰고싶은 값
		//1. 이번에 사용할 포인트 (잔여포인트를 그대로 넣으면 안됨) 만약 잔여포인트 쓰고싶으면 초과했을 때 로직이 따로 필요함 (아예 분리하거나)
		// usedPoint
		//2. 남은 포인트 remainPoint
		//3. 최종결제금액 finalPrice
		//흐름을 타보자
		//1. 간편결제일 때, 생각할 필요x 별도로 메소드 만들어서 넣어버리면 됨 (거기 결과창은 최종금액)
		//2. 일반결제이고 포인트 적립할 때 (usedPoint = 0, remainPoint=총금액*0.1+user.getU_point();, finalPrice=총금액)
		//3. 일반결제이고 포인트 쓸 때(포인트<총금액) (usedPoint = user.getU_point();, remainPoint = 0;, finalPrice=총금액-usedPoint)
		//4. 일반결제이고 포인트 쓸 때(포인트>=총금액) (usedPoint = 총 금액; remainPoint user.getU_point-총금액;, finalPrice=0;)

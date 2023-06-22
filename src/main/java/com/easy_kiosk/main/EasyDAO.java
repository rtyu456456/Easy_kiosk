package com.easy_kiosk.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EasyDAO {

	public static final EasyDAO EASYDAO = new EasyDAO();

	public EasyDAO() {
		// TODO Auto-generated constructor stub
	}

	public static EasyDAO getEasyDAO() {
		return EASYDAO;
	}

	public void whereToEat(HttpServletRequest request) { // 매장, 포장 선택 값 세션에 담기
		String whereToEat = request.getParameter("whereToEat"); // 클라이언트가 선택한 버튼의 값 가져오기
		HttpSession session = request.getSession();
		session.setAttribute("whereToEat", whereToEat); // 세션에 선택한 주문 유형 저장
	}

	public HttpSession orderType(HttpServletRequest request) { // 일반, 간편 선택 값 세션에 담기
		String orderType = request.getParameter("orderType");
		HttpSession session = request.getSession();
		session.setAttribute("orderType", orderType);
		return session;
	}

	public void getCustomer(HttpServletRequest request) { // 고객의 번호와 포인트 update 또는 insert
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String phoneNumber = request.getParameter("phoneNumber"); // input 안의 값
		int point = 600; // 물건 구매시 받는 포인트(임의값, 물건 구매값*0.1)
		String sql_select = "select * from EK_USER where u_no = ?";

		try {
			con = DBManager.connect();
			System.out.println("연결 성공!");
			pstmt = con.prepareStatement(sql_select);
			pstmt.setString(1, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				String sql_update = "update EK_USER set u_point = ? + ? where u_no = ?"; // 기존의 유저일 경우
//				int userPoint = rs.getInt("u_point"); // 유저의 현재 포인트
//				pstmt.close(); // 위에서 사용한 pstmt는 닫고서 다시 사용해야함
//				pstmt = con.prepareStatement(sql_update);
//				pstmt.setInt(1, userPoint); // pstmt.setInt(1, rs.getInt("u_point")); 로 할 경우 윗줄에서 pstmt.close()가 됐기 때문에
//											// rs의 값을 받아올 수 없음
//				pstmt.setInt(2, point);
//				pstmt.setString(3, phoneNumber);
//				pstmt.executeUpdate();
//				rs.close();
//				pstmt.close();
//				pstmt = con.prepareStatement(sql_select); // 아래 User에 담아주기 위해서 다시 select로 조회
//				pstmt.setString(1, phoneNumber);
//				rs = pstmt.executeQuery();
//				rs.next();
				System.out.println("등록된 유저입니다");
			} else {
				String sql_insert = "insert into EK_USER values(?, ?)"; // 새로 등록한 유저일 경우
				rs.close(); // 위에서 사용한 rs는 닫고서 다시 사용해야함
				pstmt.close();
				pstmt = con.prepareStatement(sql_insert);
				pstmt.setString(1, phoneNumber);
				pstmt.setInt(2, 0); // 최초 등록시 포인트는 0원
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

	public void usePoint(HttpServletRequest request) { // 일반 주문시 사용되는 메소드
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = (User) request.getSession().getAttribute("user"); // user bean값을 다시 User user에 담아서 getPoint를 사용할 수
																		// 있게 함
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
				System.out.println("getSavingPoint : " + user.getSavingPoint());
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				String usePoint = request.getParameter("usePoint");
				System.out.println("howPoint : " + request.getParameter("usePoint"));
				session.setAttribute("howPoint", usePoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void savePoint(HttpServletRequest request) { // 포인트 사용 안 하고 적립만 할 경우
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
				String savePoint = request.getParameter("savePoint");
				System.out.println("howPoint : " + request.getParameter("savePoint"));
				session.setAttribute("howPoint", savePoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void resetSession(HttpServletRequest request) { // 처음으로 돌아갈때 호출되는 세션 삭제
		HttpSession session = request.getSession();
		System.out.println(session);
		session.setAttribute("whereToEat", null);
		session.setAttribute("orderType", null);
		session.setAttribute("phoneNumber", null);
		session.setAttribute("user", null);
		session.setAttribute("howPoint", null);
		// orderNum은 유지
//		session.invalidate();
	}

	public void orderNum(HttpServletRequest request) {
		 HttpSession session = request.getSession();
		    String orderType = (String) session.getAttribute("orderType");
		    System.out.println(orderType);

		    // 세션에서 저장된 변수 값을 가져옴
		    Integer normalNum = (Integer) session.getAttribute("normalNum");
		    Integer simpleNum = (Integer) session.getAttribute("simpleNum");
		    if (normalNum == null) {
		        normalNum = 0; // 1부터 시작
		    }
		    if (simpleNum == null) {
		        simpleNum = 3; // 4부터 시작
		    }

		    if (orderType.equals("normalOrder")) {
		        System.out.println(orderType.equals("normalOrder"));
		        System.out.println(normalNum);
		        normalNum++;
		        session.setAttribute("orderNum", normalNum);
		        if (normalNum == 3) { // 3까지 표시됨
		            normalNum = 0;
		        }
		    } else { // if (orderType.equals("simpleOrder"))
		        System.out.println(orderType.equals("simpleOrder"));
		        System.out.println(simpleNum);
		        simpleNum++;
		        session.setAttribute("orderNum", simpleNum);
		        if (simpleNum == 6) { // 6까지 표시됨
		            simpleNum = 3;
		        }
		    }

		    // 수정된 변수 값을 세션에 다시 저장
		    session.setAttribute("normalNum", normalNum);
		    session.setAttribute("simpleNum", simpleNum);
		}
	}

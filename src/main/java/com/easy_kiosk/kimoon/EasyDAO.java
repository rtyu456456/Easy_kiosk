package com.easy_kiosk.kimoon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.easy_kiosk.db.DBManager;

public class EasyDAO {

	public static final EasyDAO EASYDAO = new EasyDAO();

	public EasyDAO() {
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

	public void howPayment(HttpServletRequest request) { // 매장, 포장 선택 값 세션에 담기
		String card = request.getParameter("card");
		String cash = request.getParameter("cash");
		HttpSession session = request.getSession();
		if (card != null) {
			session.setAttribute("howPayment", card);
		} else {
			session.setAttribute("howPayment", cash);
		}

	}

	public void getCustomer(HttpServletRequest request) { // 고객의 번호와 포인트 update 또는 insert
		User user = (User) request.getSession().getAttribute("user");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String firstInput = request.getParameter("firstInput"); // 첫 번째 input
		String secondInput = request.getParameter("secondInput"); // 두 번째 input
		String phoneNumber = firstInput + secondInput; // 첫 번째 페이지에서 넘어온 값들을 합침
		int totalPrice = user.getTotalPrice();
		System.out.println(totalPrice);
		int point = (int) (totalPrice * 0.1); // 물건 구매시 받는 포인트(임의값, 물건 구매값*0.1)
		String sql_select = "select * from EK_USER where u_no = ?";

		try {
			con = DBManager.connect();
			System.out.println("연결 성공!");
			pstmt = con.prepareStatement(sql_select);
			pstmt.setString(1, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("등록된 유저입니다");
			} else {
				System.out.println("첫 방문 고객입니다");
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
			user.setPhoneNumber(rs.getString("u_no")); // rs.getString에는 변수가 아니라 "DB내용"
			user.setSavingPoint(rs.getInt("u_point"));
			user.setRemainPoint(point);
			System.out.println("toString : " + user.toString());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void usePointForView(HttpServletRequest request) { // DB에 적용은 안 되고 고객에게 값을 보여주기 위한 메소드
		// (결제하지 않았는데 사용/적립 버튼 클릭 후 home으로 돌아갔을때 포인트 적립되는 것을 막기 위해)
		User user = (User) request.getSession().getAttribute("user"); // user bean값을 다시 User user에 담아서 getPoint를 사용할 수
																		// 있게 함
		int savingPoint = user.getSavingPoint(); // 현재 포인트
		int usedPoint = 0; // 사용할 포인트
		int remainPoint = 0; // 남은 포인트
		int totalPrice = user.getTotalPrice(); // 총 구매 가격
		int finalPrice = 0; // 최종 결제 가격
		try {
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
				System.out.println("finalPrice : " + finalPrice);
				remainPoint = 0;
			}
			user.setSavingPoint(savingPoint);
			user.setUsedPoint(usedPoint);
			user.setRemainPoint(remainPoint);
			user.setTotalPrice(totalPrice);
			user.setFinalPrice(finalPrice);
			System.out.println("userfinalprice : " + user.getFinalPrice());
			System.out.println("getPhoneNumber : " + user.getPhoneNumber());
			System.out.println("getSavingPoint : " + user.getSavingPoint());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String usePoint = request.getParameter("usePoint");
			System.out.println("howPoint : " + request.getParameter("usePoint"));
			session.setAttribute("howPoint", usePoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void usePoint(HttpServletRequest request) { // usePointForView의 계산된 값을 받아서 DB에 포인트를 사용시키는 메소드(결제 확인시 작동)
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = (User) request.getSession().getAttribute("user"); // user bean값을 다시 User user에 담아서 getPoint를 사용할 수
																		// 있게 함
		String userNo = user.getPhoneNumber();
		int savingPoint = user.getSavingPoint(); // 현재 포인트
		int usedPoint = user.getUsedPoint(); // 사용할 포인트
		int remainPoint = user.getRemainPoint(); // 남은 포인트
		System.out.println("remainPoint : " + remainPoint);
		int totalPrice = user.getTotalPrice(); // 총 구매 가격
		int finalPrice = user.getFinalPrice(); // 최종 결제 가격
		String sql = "update EK_USER set u_point = ? where u_no = ?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, remainPoint);
			pstmt.setString(2, userNo);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("포인트 사용 성공");
				user.setSavingPoint(savingPoint);
				user.setUsedPoint(usedPoint);
				user.setRemainPoint(remainPoint);
				user.setTotalPrice(totalPrice);
				user.setFinalPrice(finalPrice);
				System.out.println("getPhoneNumber : " + user.getPhoneNumber());
				System.out.println("getSavingPoint : " + user.getSavingPoint());
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			System.out.println("포인트 사용 실패");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void savePointForView(HttpServletRequest request) { // DB에 적용은 안 되고 고객에게 값을 보여주기 위한 메소드
		User user = (User) request.getSession().getAttribute("user");
		String userNo = user.getPhoneNumber();
		int savingPoint = user.getSavingPoint(); // 현재 포인트
		int usedPoint = 0; // 사용할 포인트
		int remainPoint = 0; // 남은 포인트
		int totalPrice = user.getTotalPrice(); // 총 구매 가격
		int finalPrice = 0; // 최종 결제 가격
		try {
			remainPoint = (int) (totalPrice * 0.1 + savingPoint); // 남은 포인트 = 총 구매 가격 * 0.1 + 현재 포인트
			System.out.println("totalPrice : " + totalPrice);
			System.out.println("remainPoint : " + remainPoint);
			finalPrice = totalPrice; // 최종 결제 가격 = 총 구매 가격(할인이 없기 때문)
			user.setSavingPoint(savingPoint);
			user.setUsedPoint(usedPoint);
			user.setRemainPoint(remainPoint);
			user.setFinalPrice(finalPrice);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String savePoint = request.getParameter("savePoint");
			System.out.println("howPoint : " + request.getParameter("savePoint"));
			session.setAttribute("howPoint", savePoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePoint(HttpServletRequest request) { // savePointForView의 계산된 값을 받아서 DB에 포인트를 적립시키는 메소드(결제 확인시 작동)
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = (User) request.getSession().getAttribute("user");
		String userNo = user.getPhoneNumber();
		int savingPoint = user.getSavingPoint(); // 현재 포인트
		int usedPoint = user.getUsedPoint(); // 사용할 포인트
		int remainPoint = user.getRemainPoint(); // 남은 포인트
		int finalPrice = user.getFinalPrice(); // 최종 결제 가격
		String sql = "update EK_USER set u_point = ? where u_no = ?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, remainPoint);
			pstmt.setString(2, userNo);
			if (pstmt.executeUpdate() == 1) {
				user.setSavingPoint(savingPoint);
				user.setUsedPoint(usedPoint);
				user.setRemainPoint(remainPoint);
				user.setFinalPrice(finalPrice);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void orderNum(HttpServletRequest request) { // 주문번호
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

	public void jsonToURL(HttpServletRequest request) {
		try {
			String items = request.getParameter("items");
			System.out.println(items); // json 문자열덩어리

			JSONParser jp = new JSONParser();

			JSONArray getData = (JSONArray) jp.parse(items);
			System.out.println(getData);
			int price = 0;
			int cnt = 0;
			int unitPrice = 0;
			String name = "";
			String iceOrHot = "";
			String optionSize = "";
			String shot = "";
			String syrup = "";
			String cream = "";

			User user = new User();
			for (Object item : getData) {
				JSONObject jsonObject = (JSONObject) item;
				price += (int) (long) jsonObject.get("price");
			}
			user.setTotalPrice(price);

			ArrayList<Menus> menuList = new ArrayList<Menus>();
			for (Object item : getData) {
				JSONObject jsonObject = (JSONObject) item;

				cnt = (int) (long) jsonObject.get("cnt");
				unitPrice = (int) (long) jsonObject.get("unitPrice");
				name = (String) jsonObject.get("name");
				optionSize = (String) jsonObject.get("optionSize");
				iceOrHot = (String) jsonObject.get("iceOrHot");
				shot = (String) jsonObject.get("shot");
				syrup = (String) jsonObject.get("syrup");
				cream = (String) jsonObject.get("cream");
				System.out.println("Price: " + price);
				System.out.println("cnt: " + cnt);
				System.out.println("unitPrice: " + unitPrice);
				System.out.println("name: " + name);
				System.out.println("optionSize: " + optionSize);
				System.out.println("iceOrHot: " + iceOrHot);
				System.out.println("shot: " + shot);
				System.out.println("syrup: " + syrup);
				System.out.println("cream: " + cream);
				System.out.println("------------------");
				Menus menus = new Menus();
				menus.setCnt(cnt);
				menus.setUnitPrice(unitPrice);
				menus.setName(name);
				menus.setOptionSize(optionSize);
				menus.setIceOrHot(iceOrHot);
				menus.setShot(shot);
				menus.setSyrup(syrup);
				menus.setCream(cream);
				menuList.add(menus);
			}

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("menus", menuList);
			System.out.println(user.getTotalPrice());
			System.out.println("menuList : " + menuList);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public void EasyjsonToURL(HttpServletRequest request) {
		
		try {
			String items = request.getParameter("items");
			System.out.println(items); // json 문자열덩어리

			JSONParser jp = new JSONParser();

			JSONArray getData = (JSONArray) jp.parse(items);
			System.out.println(getData);
			int price = 0;
			int cnt = 0;
			int unitPrice = 0;
			String name = "";
			String iceOrHot = "";
			String optionSize = "";
			String shot = "";
			String syrup = "";
			String cream = "";

			User user = new User();
			for (Object item : getData) {
				JSONObject jsonObject = (JSONObject) item;
				price += (int) (long) jsonObject.get("price");
			}
			user.setTotalPrice(price);

			ArrayList<Menus> menuList = new ArrayList<Menus>();
			for (Object item : getData) {
				JSONObject jsonObject = (JSONObject) item;

				cnt = (int) (long) jsonObject.get("count");
				unitPrice = (int) (long) jsonObject.get("unitPrice");
				name = (String) jsonObject.get("name");
				optionSize = (String) jsonObject.get("optionSize");
				iceOrHot = (String) jsonObject.get("iceOrHot");
				System.out.println("SimplePrice: " + price);
				System.out.println("cnt: " + cnt);
				System.out.println("unitPrice: " + unitPrice);
				System.out.println("name: " + name);
				System.out.println("optionSize: " + optionSize);
				System.out.println("iceOrHot: " + iceOrHot);
				System.out.println("shot: " + shot);
				System.out.println("syrup: " + syrup);
				System.out.println("cream: " + cream);
				System.out.println("------------------");
				Menus menus = new Menus();
				menus.setCnt(cnt);
				menus.setUnitPrice(unitPrice);
				menus.setName(name);
				menus.setOptionSize(optionSize);
				menus.setIceOrHot(iceOrHot);
				menus.setShot(shot);
				menus.setSyrup(syrup);
				menus.setCream(cream);
				menuList.add(menus);
			}

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("menus", menuList);
			System.out.println(user.getTotalPrice());
			System.out.println("menuList : " + menuList);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
	}


	public void resetSession(HttpServletRequest request) { // 처음으로 돌아갈때 호출되는 세션 삭제
		HttpSession session = request.getSession();
		System.out.println(session);
		session.setAttribute("whereToEat", null);
		session.setAttribute("orderType", null);
		session.setAttribute("user", null);
		session.setAttribute("howPoint", null);
		session.setAttribute("menus", null);
		// orderNum은 유지
//		session.invalidate();
	}

	public void resetPointAndNumber(HttpServletRequest request) { // 포인트 사용/적립 세션에서 초기화 시키는 세션(뒤로 가기 눌렀을때도 세션이 살아있는 사태를 막기 위해)
		HttpSession session = request.getSession();
		session.removeAttribute("howPoint");
		User user = (User) request.getSession().getAttribute("user");
		if(user != null) {
		user.setPhoneNumber(null);
		}
	}

	public void confirmOrder(HttpServletRequest request) { // 관리자 매상매출 테이블에 주문확인/취소용 값 넣기
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into EK_SALES values(EK_SALES_SEQ.NEXTVAL, ?, ?, ?, ?, 0, ?, SYSDATE)";
		try {
			User user = (User) request.getSession().getAttribute("user"); // user 세션 가져오기
			ArrayList<Menus> menus = (ArrayList<Menus>)request.getSession().getAttribute("menus"); // 메뉴 세션 배열로 가져오기
			HttpSession session = request.getSession();
			String whereToEat = (String) session.getAttribute("whereToEat"); // whereToEat 세션 가져오기
			String userNo = user.getPhoneNumber(); // 핸드폰 번호
			if (userNo == null) {
				userNo = "00000000";
			}
			String menuName = ""; // 아메리카노!에스프레소!카푸치노
			String menuCnt = ""; // 메뉴 갯수  2!1!3
			for (Menus menu : menus) {
				menuName += menu.getName() + "!";
				menuCnt += menu.getCnt() + "!";
			}
			int finalPrice = user.getFinalPrice(); // 포인트 기능 사용시 결제 가격
			int totalPrice = user.getTotalPrice(); // 포인트 기능 미 사용시 결제 가격
			System.out.println("result userNO : " + userNo);
			System.out.println("result menuName : " + menuName);
			System.out.println("result menuCnt : " + menuCnt);
			System.out.println("result finalPrice : " + finalPrice);
			System.out.println("result whereToEat : " + whereToEat);
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNo);
			pstmt.setString(2, menuName);
			pstmt.setString(3, menuCnt);
			if (finalPrice == 0) {
				pstmt.setInt(4, totalPrice);
			} else {
				pstmt.setInt(4, finalPrice);
			}
			pstmt.setString(5, whereToEat);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	
}

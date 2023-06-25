package com.sa.easy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.easy_kiosk.db.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;





public class EasyPageDAO {

	private ArrayList<Menu> menus;
	
	private static final EasyPageDAO EDAO = new EasyPageDAO();
	
	public EasyPageDAO() {
		
	}
	
	
	public static EasyPageDAO getEdao() {
		return EDAO;
	}

	public void getMenuCoffee(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='COFFEE' ORDER BY M_ORDER DESC";
	
		try {		
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				String no = rs.getString("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				int ice = rs.getInt("m_ice");
				int size = rs.getInt("m_size");
				String type = rs.getString("m_type");
				String type_easy = rs.getString("m_type_easy");
				String option = rs.getString("m_option");
				String desc = rs.getString("m_desc");
				int weather = rs.getInt("m_weather");
				int soldout = rs.getInt("m_soldout");
				int order = rs.getInt("m_order");
				Menu menu = new Menu(no, name, price, img, ice, size, type, type_easy, option, desc, weather, soldout, order);
				System.out.println(img);
				menus.add(menu);
				
			}
			
			request.setAttribute("menus", menus);
			
			
			
			
		} catch (Exception e) {
			System.out.println("db에러");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getMenuTea(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='TEA' ORDER BY M_ORDER DESC";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				String no = rs.getString("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				int ice = rs.getInt("m_ice");
				int size = rs.getInt("m_size");
				String type = rs.getString("m_type");
				String type_easy = rs.getString("m_type_easy");
				String option = rs.getString("m_option");
				String desc = rs.getString("m_desc");
				int weather = rs.getInt("m_weather");
				int soldout = rs.getInt("m_soldout");
				int order = rs.getInt("m_order");
				Menu menu = new Menu(no, name, price, img, ice, size, type, type_easy, option, desc, weather, soldout, order);
				
				menus.add(menu);
				
			}
			
			
			request.setAttribute("menus", menus);
			
			
			
			
		} catch (Exception e) {
			System.out.println("db에러");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	
	}

	public void getMenuDessert(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='DESSERT' ORDER BY M_ORDER DESC";
	
		try {
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				String no = rs.getString("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				int ice = rs.getInt("m_ice");
				int size = rs.getInt("m_size");
				String type = rs.getString("m_type");
				String type_easy = rs.getString("m_type_easy");
				String option = rs.getString("m_option");
				String desc = rs.getString("m_desc");
				int weather = rs.getInt("m_weather");
				int soldout = rs.getInt("m_soldout");
				int order = rs.getInt("m_order");
				Menu menu = new Menu(no, name, price, img, ice, size, type, type_easy, option, desc, weather, soldout, order);
				
				menus.add(menu);
				
			}
			
			
			request.setAttribute("menus", menus);
			
			
			
			
		} catch (Exception e) {
			System.out.println("db에러");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public void getMenuDrink(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='BEVERAGE' ORDER BY M_ORDER DESC";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				String no = rs.getString("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				int ice = rs.getInt("m_ice");
				int size = rs.getInt("m_size");
				String type = rs.getString("m_type");
				String type_easy = rs.getString("m_type_easy");
				String option = rs.getString("m_option");
				String desc = rs.getString("m_desc");
				int weather = rs.getInt("m_weather");
				int soldout = rs.getInt("m_soldout");
				int order = rs.getInt("m_order");
				Menu menu = new Menu(no, name, price, img, ice, size, type, type_easy, option, desc, weather, soldout, order);
				
				menus.add(menu);
				
			}
			
			
			request.setAttribute("menus", menus);
			
			
			
			
		} catch (Exception e) {
			System.out.println("db에러");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	
	
	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		
		int cnt = 4; // 한페이지당 보여줄 개수
		int total = menus.size(); // 총 데이터 개수
		// 4
		int pageCount = (int)Math.ceil((double)total / cnt); // 총 페이지 수
		// 4
		request.setAttribute("pageCount", pageCount);
		System.out.println(pageCount);
		int start = (page - 1) * cnt;
		// 1 = 1
		
		int end = (page == pageCount) ? total: start + cnt;
		// END =  4
		
		ArrayList<Menu> items = new ArrayList<Menu>();
		for (int i = start; i < end ; i++) {
			items.add(menus.get(i));
		}
		request.setAttribute("menus", items);
	}

}

package com.sa.easy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class EasyPageDAO {

	public static void getAllMenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				String no = rs.getString("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				String ice = rs.getString("m_ice");
				String type = rs.getString("m_type");
				String type_easy = rs.getString("m_type_easy");
				String weather = rs.getString("m_weather");
				String stock = rs.getString("m_stock");
				Menu menu = new Menu(no, name, price, img, ice, type, type_easy, weather, stock);
				
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

	public static void getMenuCoffee(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='COFFEE'";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				Menu menu = new Menu();
				menu.setM_name(rs.getString("m_name"));
				menu.setM_no(rs.getString("m_no"));
				menu.setM_img(rs.getString("m_img"));
				menu.setM_price(rs.getInt("m_price"));
				
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

	public static void getMenuTea(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='TEA'";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				Menu menu = new Menu();
				menu.setM_name(rs.getString("m_name"));
				menu.setM_no(rs.getString("m_no"));
				menu.setM_img(rs.getString("m_img"));
				menu.setM_price(rs.getInt("m_price"));
				
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

	public static void getMenuDessert(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='DESSERT'";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				Menu menu = new Menu();
				menu.setM_name(rs.getString("m_name"));
				menu.setM_no(rs.getString("m_no"));
				menu.setM_img(rs.getString("m_img"));
				menu.setM_price(rs.getInt("m_price"));
				
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

	public static void getMenuDrink(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from EK_MENU where m_type_EASY='BEVERAGE'";
	
		try {
			
			
			con = DBManager.connect();
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				
				Menu menu = new Menu();
				menu.setM_name(rs.getString("m_name"));
				menu.setM_no(rs.getString("m_no"));
				menu.setM_img(rs.getString("m_img"));
				menu.setM_price(rs.getInt("m_price"));
				
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

}

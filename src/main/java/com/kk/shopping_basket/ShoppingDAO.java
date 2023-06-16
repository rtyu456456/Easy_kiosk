package com.kk.shopping_basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ShoppingDAO {
		
		
	public static void showAllMenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ek_menu";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>(); 
			while (rs.next()) {
				int no = rs.getInt("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				int ice = rs.getInt("m_ice");
				String type = rs.getString("m_type");
				String typeeasy = rs.getString("m_type_easy");
				int weather = rs.getInt("m_weather");
				int stock = rs.getInt("m_stock");
				menus.add(new Menu(no, name, price, img, ice, type, typeeasy, weather, stock));
			}
			request.setAttribute("menus", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void getMenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ek_menu where m_no = ?";
				
			try {
				con = DBManager.connect();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("no"));
				rs = pstmt.executeQuery();
				
				ArrayList<Menu> men = new ArrayList<Menu>(); 
				while (rs.next()) {
					int no = rs.getInt("m_no");
					String name = rs.getString("m_name");
					int price = rs.getInt("m_price");
					String img = rs.getString("m_img");
					int ice = rs.getInt("m_ice");
					String type = rs.getString("m_type");
					String typeeasy = rs.getString("m_type_easy");
					int weather = rs.getInt("m_weather");
					int stock = rs.getInt("m_stock");
					men.add(new Menu(no, name, price, img, ice, type, typeeasy, weather, stock));
				}
				request.setAttribute("men", men);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void regCart(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ek_cart values (?,?)";
		Menu c_menu = (Menu) request.getAttribute("men");
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			pstmt.setInt(2, 1);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공!");
				request.setAttribute("r", "등록 성공!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void showCart(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EK_MENU WHERE M_NO INTO (SELECT C_NO FROM EK_CART)";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> men = new ArrayList<Menu>(); 
			while (rs.next()) {
				int no = rs.getInt("m_no");
				String name = rs.getString("m_name");
				int price = rs.getInt("m_price");
				String img = rs.getString("m_img");
				int ice = rs.getInt("m_ice");
				String type = rs.getString("m_type");
				String typeeasy = rs.getString("m_type_easy");
				int weather = rs.getInt("m_weather");
				int stock = rs.getInt("m_stock");
				men.add(new Menu(no, name, price, img, ice, type, typeeasy, weather, stock));
			}
			request.setAttribute("men", men);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
	
}

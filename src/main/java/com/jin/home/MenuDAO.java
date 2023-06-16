package com.jin.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class MenuDAO {

	public static void showAllCoffee(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'COFFEE'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				String ice = rs.getString("M_ICE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String weather = rs.getString("M_WEATHER");
				String stock = rs.getString("M_STOCK");
				menus.add(new Menu(no, name, price, img, ice, type, typeEasy, weather, stock));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}

	public static void showAllTea(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'TEA'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				String ice = rs.getString("M_ICE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String weather = rs.getString("M_WEATHER");
				String stock = rs.getString("M_STOCK");
				menus.add(new Menu(no, name, price, img, ice, type, typeEasy, weather, stock));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void showAllBeverage(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'BEVERAGE'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				String ice = rs.getString("M_ICE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String weather = rs.getString("M_WEATHER");
				String stock = rs.getString("M_STOCK");
				menus.add(new Menu(no, name, price, img, ice, type, typeEasy, weather, stock));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void showAllDesert(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'DESSERT'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				String ice = rs.getString("M_ICE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String weather = rs.getString("M_WEATHER");
				String stock = rs.getString("M_STOCK");
				menus.add(new Menu(no, name, price, img, ice, type, typeEasy, weather, stock));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void showAllShakeAde(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'SHAKE_ADE'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				String ice = rs.getString("M_ICE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String weather = rs.getString("M_WEATHER");
				String stock = rs.getString("M_STOCK");
				menus.add(new Menu(no, name, price, img, ice, type, typeEasy, weather, stock));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

}

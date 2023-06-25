package com.jin.general;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.easy_kiosk.db.DBManager;

public class GeneralMenuDAO {
	
	private ArrayList<GeneralMenu> menus;
	
	private static final GeneralMenuDAO GDAO = new GeneralMenuDAO();
	
	public GeneralMenuDAO() {
		
	}
	
	public static GeneralMenuDAO getGdao() {
		return GDAO;
	}

	public void showAllCoffee(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'COFFEE' ORDER BY M_ORDER DESC";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public void showAllBeverage(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'BEVERAGE'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void showAllBlendingTea(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'BLENDING_TEA'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void showAllFlatccino(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'FLATCCINO'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void showAllShakeAde(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'SHAKE_ADE'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void showAllIceFlake(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'ICE_FLAKE'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void showAllBread(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from EK_MENU where M_TYPE = 'BREAD'";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			menus = new ArrayList<GeneralMenu>();
			while (rs.next()) {
				String no = rs.getString("M_NO");
				String name = rs.getString("M_NAME");
				int price = rs.getInt("M_PRICE");
				String img = rs.getString("M_IMG");
				int ice = rs.getInt("M_ICE");
				int size = rs.getInt("M_SIZE");
				String type = rs.getString("M_TYPE");
				String typeEasy = rs.getString("M_TYPE_EASY");
				String option = rs.getString("M_OPTION");
				String desc = rs.getString("M_DESC");
				int weather = rs.getInt("M_WEATHER");
				int soldout = rs.getInt("M_SOLDOUT");
				int order = rs.getInt("M_ORDER");
				menus.add(new GeneralMenu(no, name, price, img, ice, size, type, typeEasy, option, desc, weather, soldout, order));
			}
			request.setAttribute("M", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void generalMenuPaging(int page, HttpServletRequest request) {
		
        request.setAttribute("curPageNo", page);

        int cnt = 12; // ���������� ������ ����
        int total = menus.size(); // �� ������ ����
        // 4
        int pageCount = (int)Math.ceil((double)total / cnt); // �� ������ ��
        // 4
        request.setAttribute("pageCount", pageCount);
        System.out.println(pageCount);
        int start = (page - 1) * cnt;
        // 1 = 1

        int end = (page == pageCount) ? total: start + cnt;
        // END =  4

        ArrayList<GeneralMenu> items = new ArrayList<GeneralMenu>();
        for (int i = start; i < end ; i++) {
            items.add(menus.get(i));
        }
        request.setAttribute("M", items);
		
	}



}

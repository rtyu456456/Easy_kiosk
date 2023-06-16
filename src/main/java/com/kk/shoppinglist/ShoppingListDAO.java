package com.kk.shoppinglist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kk.shopping_basket.DBManager;
import com.kk.shopping_basket.Menu;


public class ShoppingListDAO {

	public static void showAllList(HttpServletRequest request) {
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
		
}

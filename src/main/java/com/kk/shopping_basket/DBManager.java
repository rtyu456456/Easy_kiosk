package com.kk.shopping_basket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {
	
	public static Connection connect() throws Exception {
		String url = "jdbc:oracle:thin:@qwywatff3dircwtm_high?TNS_ADMIN=C:/SBT7/dbws/Wallet_QWYWATFF3DIRCWTM";
		System.out.println("연결 성공!");
		return DriverManager.getConnection(url, "ADMIN", "Soldesk802!!");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if (rs != null) {
			rs.close();			
		}
			pstmt.close();
			con.close();
		} 	catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.kkh.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@qwywatff3dircwtm_high?TNS_ADMIN=C:/kkh/eclipseDB/Wallet_QWYWATFF3DIRCWTM";
		return DriverManager.getConnection(url, "ADMIN" , "Soldesk802!!");
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
		
			try {
				if(rs != null) {
				rs.close();
				}
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
	
}

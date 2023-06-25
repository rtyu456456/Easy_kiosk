package com.jin.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// db���� �۾��� �Ҷ� �����ڵ带 �� ���Ŀ� �۾� �ؿ�
// �� ���� ����

// �װ� AOP ����
public class DBManager {
	
	// db�۾��ÿ� ��¶�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@qwywatff3dircwtm_high?TNS_ADMIN=C:/kkh/eclipseDB/Wallet_QWYWATFF3DIRCWTM";
		System.out.println("연결/실행 성공");
		return DriverManager.getConnection(url, "ADMIN", "Soldesk802!!");
	}
	
	// ������ ������ �ѹ��� �ݱ�
	public static void close(
			Connection con, 
			PreparedStatement pstmt, 
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			  }
				pstmt.close();
				con.close();
			}  catch (SQLException e) {
				e.printStackTrace();
			} 
		
	}
	
	
}

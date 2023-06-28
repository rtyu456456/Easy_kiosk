package com.kkh.manage;

import java.nio.file.spi.FileSystemProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ManageDAO {

	public static void showAllmenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EK_MENU ORDER BY M_ORDER DESC";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setM_no(rs.getInt("M_NO"));
				menu.setM_name(rs.getString("M_NAME"));
				menu.setM_price(rs.getInt("M_PRICE"));
				menu.setM_img(rs.getString("M_IMG"));
				menu.setM_ice(rs.getInt("M_ICE"));
				menu.setM_size(rs.getInt("M_SIZE"));
				menu.setM_type(rs.getString("M_TYPE"));
				menu.setM_type_easy(rs.getString("M_TYPE_EASY"));
				menu.setM_option(rs.getString("M_OPTION"));
				menu.setM_desc(rs.getString("M_DESC"));
				menu.setM_weather(rs.getInt("M_WEATHER"));
				menu.setM_soldout(rs.getInt("M_SOLDOUT"));
				menu.setM_order(rs.getInt("M_ORDER"));
				menus.add(menu);
			}

			request.setAttribute("menus", menus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void showTypemenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EK_MENU WHERE M_TYPE LIKE ? ORDER BY M_ORDER DESC";
		String type = request.getParameter("type");

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();

			ArrayList<Menu> menus = new ArrayList<Menu>();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setM_no(rs.getInt("M_NO"));
				menu.setM_name(rs.getString("M_NAME"));
				menu.setM_price(rs.getInt("M_PRICE"));
				menu.setM_img(rs.getString("M_IMG"));
				menu.setM_ice(rs.getInt("M_ICE"));
				menu.setM_size(rs.getInt("M_SIZE"));
				menu.setM_type(rs.getString("M_TYPE"));
				menu.setM_type_easy(rs.getString("M_TYPE_EASY"));
				menu.setM_option(rs.getString("M_OPTION"));
				menu.setM_desc(rs.getString("M_DESC"));
				menu.setM_weather(rs.getInt("M_WEATHER"));
				menu.setM_soldout(rs.getInt("M_SOLDOUT"));
				menu.setM_order(rs.getInt("M_ORDER"));
				menus.add(menu);
			}

			request.setAttribute("menus", menus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void addMenu(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO EK_MENU VALUES(EK_MENU_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String path = request.getServletContext().getRealPath("imgs");

		try {
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mr.getParameter("m_name"));
			System.out.println(mr.getParameter("m_name"));
			pstmt.setString(2, mr.getParameter("m_price"));
			System.out.println(mr.getParameter("m_price"));
			if (mr.getFilesystemName("m_img") == null) { // 이미지 예외처리
				pstmt.setString(3, "default.png");
			} else {
				pstmt.setString(3, mr.getFilesystemName("m_img"));
			}
			pstmt.setString(4, mr.getParameter("m_ice"));
			pstmt.setString(5, mr.getParameter("m_size"));
			pstmt.setString(6, mr.getParameter("m_type"));
			pstmt.setString(7, mr.getParameter("m_type_easy"));
			// checkbox로 된 m_option 배열로 받아서 처리
			String[] m_option = mr.getParameterValues("m_option");
			String m_option2 = "";
			if (m_option != null) {
				for (int i = 0; i < m_option.length; i++) {
					if (i == m_option.length - 1) {
						m_option2 += m_option[i];
					} else {
						m_option2 += m_option[i] + "!";
					}
				}
			} else {
				m_option2 = "NONE";
			}
			pstmt.setString(8, m_option2);
			// 메뉴소개 없을 시 공백 문자열로 표시 및 줄바꿈 처리
			String m_desc = mr.getParameter("m_desc");
			System.out.println(m_desc);
			if (m_desc.isEmpty()) {
				m_desc = "";
			} else {
				m_desc = m_desc.replaceAll("\r\n", "<br>");
			}
			pstmt.setString(9, m_desc);
			pstmt.setString(10, mr.getParameter("m_weather"));
			pstmt.setString(11, mr.getParameter("m_soldout"));
			pstmt.setString(12, mr.getParameter("m_order"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록성공");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void deleteMenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM EK_MENU WHERE M_NO = ?";
		String m_no = request.getParameter("m_no");

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_no);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void updateMenu(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE EK_MENU SET M_NAME = ?, M_PRICE = ?, M_IMG = ?, M_ICE = ?, M_SIZE = ?,  M_TYPE = ?, M_TYPE_EASY = ?, M_OPTION = ?, M_DESC = ?, M_WEATHER = ?, M_SOLDOUT =?, M_ORDER = ? WHERE M_NO = ?";
		String path = request.getServletContext().getRealPath("imgs");

		try {
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mr.getParameter("m_name"));
			pstmt.setString(2, mr.getParameter("m_price"));
			if (mr.getFilesystemName("m_new_img") == null) {
				pstmt.setString(3, mr.getParameter("m_old_img"));
			} else {
				pstmt.setString(3, mr.getFilesystemName("m_new_img"));
			}
			pstmt.setString(4, mr.getParameter("m_ice"));
			pstmt.setString(5, mr.getParameter("m_size"));
			pstmt.setString(6, mr.getParameter("m_type"));
			pstmt.setString(7, mr.getParameter("m_type_easy"));
			// checkbox로 된 m_option 배열로 받아서 처리
			String[] m_option = mr.getParameterValues("m_option");
			String m_option2 = "";
			if (m_option != null) {
				for (int i = 0; i < m_option.length; i++) {
					if (i == m_option.length - 1) {
						m_option2 += m_option[i];
					} else {
						m_option2 += m_option[i] + "!";
					}
				}
			} else {
				m_option2 = "NONE";
			}
			pstmt.setString(8, m_option2);
			pstmt.setString(9, mr.getParameter("m_desc"));
			pstmt.setString(10, mr.getParameter("m_weather"));
			pstmt.setString(11, mr.getParameter("m_soldout"));
			pstmt.setString(12, mr.getParameter("m_order"));
			pstmt.setString(13, mr.getParameter("m_no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("수정성공");
				request.setAttribute("m_no", mr.getParameter("m_no"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void getMenu(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EK_MENU WHERE M_NO LIKE ?";
		String m_no = request.getParameter("m_no");

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_no);
			rs = pstmt.executeQuery();

			rs.next();
			ArrayList<Menu> menus = new ArrayList<Menu>();
			Menu menu = new Menu();
			menu.setM_no(rs.getInt("M_NO"));
			menu.setM_name(rs.getString("M_NAME"));
			menu.setM_price(rs.getInt("M_PRICE"));
			menu.setM_img(rs.getString("M_IMG"));
			menu.setM_ice(rs.getInt("M_ICE"));
			menu.setM_size(rs.getInt("M_SIZE"));
			menu.setM_type(rs.getString("M_TYPE"));
			menu.setM_type_easy(rs.getString("M_TYPE_EASY"));
			menu.setM_option(rs.getString("M_OPTION"));
			menu.setM_desc(rs.getString("M_DESC"));
			menu.setM_weather(rs.getInt("M_WEATHER"));
			menu.setM_soldout(rs.getInt("M_SOLDOUT"));
			menu.setM_order(rs.getInt("M_ORDER"));
			menus.add(menu);
			request.setAttribute("menu", menu);
			request.setAttribute("menus", menus);

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void paging(int page, HttpServletRequest request) {

		ArrayList<Menu> menus = (ArrayList<Menu>) request.getAttribute("menus");
		request.setAttribute("curPageNo", page);

		int cnt = 3; // 한 페이지당 보여줄 개수
		int total = menus.size(); // 총 데이터 개수
		int pageCount = (int) Math.ceil((double) total / cnt);

		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Menu> items = new ArrayList<Menu>();
		for (int i = start - 1; i > end; i--) {
			items.add(menus.get(i));
		}

		request.setAttribute("menus", items);
	}

}

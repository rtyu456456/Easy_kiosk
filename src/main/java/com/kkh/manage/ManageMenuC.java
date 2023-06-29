package com.kkh.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageMenuC")
public class ManageMenuC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("type") == null) {
			if (request.getParameter("m_no") == null) {
				ManageDAO.showAllmenu(request);
				ManageDAO.paging(1, request);
			} else {
				ManageDAO.getMenu(request);
			}
		} else {
			ManageDAO.showTypemenu(request);
			ManageDAO.paging(1, request);
		}
		request.setAttribute("contentPage", "manage_menu.jsp");
		request.getRequestDispatcher("jsp/manage/manage_index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

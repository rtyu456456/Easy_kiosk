package com.kkh.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMenuC")
public class AddMenuC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("type"));
		
		if (request.getParameter("type") == null) {
			ManageDAO.showAllmenu(request);
		} else {
			ManageDAO.showTypemenu(request);
		}
		request.setAttribute("contentPage", "manage_menu_add.jsp");
		request.getRequestDispatcher("jsp/manage/manage_index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageDAO.addMenu(request);
		response.sendRedirect("ManageMenuC");
	
	}

}

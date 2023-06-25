package com.easy_kiosk.generalmenu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GeneralPageCon")
public class GeneralPageCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GeneralMenuDAO.getGdao().generalMenuPaging(Integer.parseInt(request.getParameter("p")), request);
		request.setAttribute("navigation", "GeneralNavigation.jsp");
		request.setAttribute("contentPage", "GeneralMenuItem.jsp");
		request.getRequestDispatcher("jsp/generalMenu/GeneralMenu.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}

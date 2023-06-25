package com.easy_kiosk.taejin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GeneralCoffeeCon")
public class GeneralCoffeeCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GeneralMenuDAO.getGdao().showAllCoffee(request);
		GeneralMenuDAO.getGdao().generalMenuPaging(1, request);
		request.setAttribute("navigation", "GeneralNavigation.jsp");
		request.setAttribute("contentPage", "GeneralMenuItem.jsp");
		request.getRequestDispatcher("jsp/generalMenu/GeneralMenu.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}

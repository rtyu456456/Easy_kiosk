package com.sa.easy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EasyPageDAO.getAllMenu(request);
		
		
		request.setAttribute("easyTitlePage", "jsp/easy_title_page.jsp");
		request.setAttribute("easyContentsPage", "jsp/easy_contents_page.jsp");
		request.getRequestDispatcher("menu_page.jsp").forward(request, response);
	
	}

}

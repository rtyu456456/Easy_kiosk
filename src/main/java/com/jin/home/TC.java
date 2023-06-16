package com.jin.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TC")
public class TC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDAO.showAllTea(request);
		request.setAttribute("contentPage", "jsp/Main_Menuitem.jsp");
		request.getRequestDispatcher("Main_Menu.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}

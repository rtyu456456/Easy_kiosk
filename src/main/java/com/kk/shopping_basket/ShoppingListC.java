package com.kk.shopping_basket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShoppingListC")
public class ShoppingListC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				ShoppingDAO.showAllMenu(request);
				ShoppingDAO.getMenu(request);
				request.setAttribute("contentPage", "jsp/shopping_menu.jsp");
				request.getRequestDispatcher("main_menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

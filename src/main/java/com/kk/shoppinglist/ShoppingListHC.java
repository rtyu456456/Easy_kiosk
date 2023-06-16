package com.kk.shoppinglist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kk.shopping_basket.ShoppingDAO;

@WebServlet("/ShoppingListHC")
public class ShoppingListHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ShoppingListDAO.showAllList(request);
			request.setAttribute("contentPage", "jsp/shopping_list/shopping_list_page.jsp");
			request.getRequestDispatcher("main_menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}

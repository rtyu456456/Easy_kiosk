package com.sa.easy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BasketController")
public class BasketController extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		
		
		  String price = request.getParameter("price"); 
		  String ice = request.getParameter("ice"); 
		  String count = request.getParameter("count");
		  String name = request.getParameter("name");
		  String size = request.getParameter("size"); 
		  String img = request.getParameter("img");
		  
		  SelectedMenu selectedMenu = new SelectedMenu(price, ice, count, name, size, img);
	
		  request.setAttribute("a", selectedMenu);
				
		  
		

		
		request.setAttribute("easyBasketPage", "jsp/easy_basket.jsp");
		request.setAttribute("easyTitlePage", "jsp/easy_title_page.jsp");
		request.setAttribute("easyContentsPage", "jsp/easy_contents_page.jsp");
		request.getRequestDispatcher("menu_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

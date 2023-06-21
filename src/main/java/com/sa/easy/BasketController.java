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
		
	String price = request.getParameter("pocketPrice");
	String ice = request.getParameter("pocketIce");
	String count = request.getParameter("pocketCount");
	String name = request.getParameter("pocketName");
	String size = request.getParameter("pocketSize");
	String img = request.getParameter("pocketImg");
		
	SelectedMenu selectedMenu = new SelectedMenu(price, ice, count, name, size, img);
	
		request.setAttribute("a", selectedMenu);
				
				
		System.out.println(request.getParameter("pocketIce"));
		System.out.println(request.getParameter("pocketCount"));
		System.out.println(request.getParameter("pocketName"));
		System.out.println(request.getParameter("pocketSize"));
		System.out.println(request.getParameter("pocketImg"));
		
	

		
		request.setAttribute("easyBasketPage", "jsp/easy_basket.jsp");
		request.setAttribute("easyTitlePage", "jsp/easy_title_page.jsp");
		request.setAttribute("easyContentsPage", "jsp/easy_contents_page.jsp");
		request.getRequestDispatcher("menu_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

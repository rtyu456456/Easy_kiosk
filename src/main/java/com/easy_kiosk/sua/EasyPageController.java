package com.easy_kiosk.sua;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EasyPageController")
public class EasyPageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EasyPageDAO.getEdao().paging(Integer.parseInt(request.getParameter("p")), request);
		
		request.setAttribute("easyBasketPage", "easy_basket.jsp");
		request.setAttribute("easyTitlePage", "easy_title_page.jsp");
		request.setAttribute("easyContentsPage", "easy_contents_page.jsp");
		request.getRequestDispatcher("jsp/easyMenu/menu_page.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

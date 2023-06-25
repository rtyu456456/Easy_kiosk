package com.easy_kiosk.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HC 진입");
		EasyDAO.getEasyDAO().resetSession(request);
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("contentPage", "main.jsp");
		request.setAttribute("audioSource", "../mp3/01_Easy_Coffee에_오신_것을_환영합니다.mp3");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		// html로 하면 메소드나 System.out같은 '기능'들이 동작하지 않음!
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
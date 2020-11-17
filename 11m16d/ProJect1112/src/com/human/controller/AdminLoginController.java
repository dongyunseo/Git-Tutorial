package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.adminLoginCommand.AdminLoginInterface;
import com.human.adminLoginCommand.AdminLoginCommand;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("*.io")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AdminLoginController doget");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("AdminLoginController doPost");
		request.setCharacterEncoding("UTF-8");
		AdminLoginInterface iCom = null;

		// 사용자에게 보여줄 view 설정
		String viewPage = null;
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);

		if (com.equals("/Adminlogin/admin.io")) {
			iCom = new AdminLoginCommand();
			iCom.execute(request, response);
			String temp = (String) request.getAttribute("temp");

			if (temp == "1") {
				String id = (String) request.getAttribute("id");
				HttpSession session = request.getSession();

				session.setAttribute("login_Id", id);
				session.setMaxInactiveInterval(10000);
				response.sendRedirect("../Adminlogin/AdminLoginSuccess.jsp");
			} else {
				viewPage = "../Adminlogin/Admin_login_fail.jsp";
				response.sendRedirect("../Adminlogin/Admin_login_fail.jsp");
			}
		} else if (com.equals("/logout.io")) {
			viewPage = "AdminMain.jsp";
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("Adminlogin/AdminMain.lo");

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}

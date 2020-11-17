package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.membercommand.GetIdCommand;
import com.human.membercommand.GetPwdCommand;
import com.human.membercommand.MemberCommand;
import com.human.membercommand.NewJoinCommand;
import com.human.membercommand.NewLoginCommand;

/**
 * Servlet implementation class idCheckServlet
 */
@WebServlet("*.so")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberController (doGet)");
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MemberController (doPost)");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		MemberCommand bCom = null;
		String viewPage = null;

		String uri = request.getRequestURI();
		System.out.println(uri);

		String conPath = request.getContextPath();
		System.out.println(conPath);

		String com = uri.substring(conPath.length());
		System.out.println(com);

		 if (com.equals("/Member/signupNew.so")) {
			viewPage = "main_Newjoin.jsp";
			bCom = new NewJoinCommand();
			bCom.execute(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else if (com.equals("/Member/login.so")) {
			bCom = new NewLoginCommand();
			bCom.execute(request, response);
			String temp = (String) request.getAttribute("temp");

			if (temp == "1") {
				String name = (String) request.getAttribute("name");
				String useyn = (String) request.getAttribute("useyn");
				String id = (String) request.getAttribute("id");
				HttpSession session = request.getSession();

				session.setAttribute("login_Name", name);
				session.setAttribute("login_Id", id);
				session.setAttribute("login_Useyn", useyn);

				session.setMaxInactiveInterval(10000);
				response.sendRedirect("../Main&Category/main.do");
			} else {
				viewPage = "../Member/main_login_fail.jsp";
				response.sendRedirect("../Member/main_login_fail.jsp");
			}
		} else if (com.equals("/logout.so")) {
			// �슖�돦裕꾬옙�쟽�뜝�럥�닡�뜝�럩�쐨
			viewPage = "main.jsp";
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("Main&Category/main.do");
			// id pw 찾기-------------------------------------------
		} else if (com.equals("/Member/idforgot.so")) {
			viewPage = "GETID.jsp";
			System.out.println(viewPage);
			bCom = new GetIdCommand();
			bCom.execute(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else if (com.equals("/Member/pwdforgot.so")) {
			viewPage = "GETPWD.jsp";
			bCom = new GetPwdCommand();
			bCom.execute(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}

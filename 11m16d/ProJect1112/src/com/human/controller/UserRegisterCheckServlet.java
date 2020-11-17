package com.human.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.MemberDao;
import com.human.dao.ProDao;
import com.human.dto.ProDto;

/**
 * Servlet implementation class UserRegisterCheckServlet
 */
@WebServlet("/UserRegisterCheckServlet")
public class UserRegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserRegisterCheckServlet doPost");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");

		System.out.println(id + "중복체크 중...");
		response.getWriter().write(new MemberDao().checkId(id) + "");

	}

}
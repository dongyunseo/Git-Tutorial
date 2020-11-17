package com.human.adminLoginCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.AdminDao;
import com.human.dto.AdminVO;

public class AdminLoginCommand implements AdminLoginInterface{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		AdminDao aDao = new AdminDao();
		AdminVO adminVO = new AdminVO();
		
		String temp = aDao.login(id, pwd, adminVO);
		String id1 = adminVO.getId();
		
		request.setAttribute("temp", temp);
		request.setAttribute("id", id1);
	}

}

package com.human.membercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.MemberDao;

public class NewJoinCommand implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		String name = request.getParameter("name");
		System.out.println(name);
		String email = request.getParameter("email");
		System.out.println(email);
		String zip_num = request.getParameter("zip_num");
		System.out.println(zip_num);
		String address = request.getParameter("address");
		System.out.println(address);
		String phone = request.getParameter("phone");
		System.out.println(phone);
	
		
		MemberDao mDao = new MemberDao();
		
		mDao.insertNewJoin(id,pwd,name,email,zip_num,address,phone);
		
		request.setAttribute("name", name);
		
		
	}
}
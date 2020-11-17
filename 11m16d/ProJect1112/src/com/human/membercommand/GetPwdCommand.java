package com.human.membercommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.MemberDao;
import com.human.dto.MemberVo;

public class GetPwdCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		System.out.println(name);
		String email = request.getParameter("email");
		System.out.println(email);

		MemberDao mDao = new MemberDao();
		MemberVo dtoid = mDao.GetId(name, email);
		request.setAttribute("dtoid", dtoid);

	}

}

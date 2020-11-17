package com.human.adminsCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dao.ProDao;
import com.human.dto.ProDto;

public class adminProductDetail implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String dressid = request.getParameter("dressid");
		String dressname = request.getParameter("dressname");

		ProDao dao = new ProDao();
		ProDto dto = dao.select(dressid);
		request.setAttribute("dto", dto);
		
		if (dressname != null) {
			ProDto proDto = new ProDto();
			proDto.setDressid(Integer.parseInt(request.getParameter("dressid")));
			proDto.setDressname(request.getParameter("dressname"));
			proDto.setPrice(Integer.parseInt(request.getParameter("price")));
			dao = ProDao.getInstance();
			dao.dressupdate(proDto);
			
			dao = new ProDao();
			dto = dao.select(dressid);
			request.setAttribute("dto", dto);
		}
	}

}

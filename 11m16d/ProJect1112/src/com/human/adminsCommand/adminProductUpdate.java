package com.human.adminsCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.OrderDao;
import com.human.dao.ProDao;
import com.human.dto.OrderVO;
import com.human.dto.ProDto;

public class adminProductUpdate implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String dressid = request.getParameter("dressid");

		ProDao dao = ProDao.getInstance();
		ProDto dto = dao.select(dressid);
		request.setAttribute("dto", dto);

		ProDto proDto = new ProDto();
		proDto.setDressid(Integer.parseInt(request.getParameter("dressid")));
		proDto.setDressname(request.getParameter("dressname"));
		proDto.setPrice(Integer.parseInt(request.getParameter("price")));
		dao = ProDao.getInstance();
		dao.dressupdate(proDto);
	}
}
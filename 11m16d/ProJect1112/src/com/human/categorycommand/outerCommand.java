package com.human.categorycommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.ProDao;
import com.human.dto.ProDto;

public class outerCommand implements ProCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProDao ProDao = new ProDao();
		
		ArrayList<ProDto> dtos = ProDao.selectouter();
		request.setAttribute("dtos", dtos);
	}
}
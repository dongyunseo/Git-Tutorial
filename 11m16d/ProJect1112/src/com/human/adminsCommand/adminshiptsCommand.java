package com.human.adminsCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.ProDao;
import com.human.dto.ProDto;

public class adminshiptsCommand implements AdminInterface {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProDao ProDao = new ProDao();

		ArrayList<ProDto> dtos = ProDao.selectcategoryshipts();
		request.setAttribute("dtos", dtos);
	}
}

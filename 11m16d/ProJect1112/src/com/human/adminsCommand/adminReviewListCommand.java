package com.human.adminsCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.QandADao;
import com.human.dao.ReviewDao;
import com.human.dto.QandAVo;
import com.human.dto.ReviewVO;

public class adminReviewListCommand implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ReviewDao rDao = ReviewDao.getInstance();
		ArrayList<ReviewVO> ReviewAllList = rDao.selectAllReview();
		request.setAttribute("ReviewAllList",ReviewAllList);
	
	}


}

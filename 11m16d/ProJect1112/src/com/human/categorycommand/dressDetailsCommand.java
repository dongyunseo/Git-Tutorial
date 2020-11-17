package com.human.categorycommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dao.ProDao;
import com.human.dao.QandADao;
import com.human.dao.ReviewDao;
import com.human.dto.ProDto;
import com.human.dto.QandAVo;
import com.human.dto.ReviewCountDto;
import com.human.dto.ReviewVO;

public class dressDetailsCommand implements ProCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login_Id");
		String qandaid = request.getParameter("qandaid");
		String loginid = request.getParameter("loginid");
		String dressid = request.getParameter("dressid");
		String qandatitle = request.getParameter("qandatitle");
		qandatitle = request.getParameter("qandatitle");
//--------------------상세페이지 상품 출력-------------------------
	
		ProDao dao = new ProDao();
		ProDto dto = dao.select(dressid);
		request.setAttribute("dto", dto);

//--------------------상세페이지 Q&A Insert-------------------------
		if (qandatitle != null) {
			QandAVo qandAVo = new QandAVo();
			qandAVo.setQandatitle(request.getParameter("qandatitle"));
			qandAVo.setQandacontent(request.getParameter("qandacontent"));
			qandAVo.setId(id);
			qandAVo.setDressid(Integer.parseInt(request.getParameter("dressid")));
			dressid = request.getParameter("dressid");
			System.out.println(dressid);
			QandADao qandADao = QandADao.getInstance();
			qandADao.insertQandA(qandAVo);
		}

//---------------------Q&A 삭제---------------------------------
		if (qandaid != null && id != null) {
			System.out.println("게시글 넘버 = " + qandaid);
			System.out.println("현제 로그인 된 아이디 = " + loginid);

			QandADao qandAVo = QandADao.getInstance();
			qandAVo.QandAdelete(qandaid, id);

		}

// -------------------상세페이지 리뷰출력 페이징--------------------------------
		System.out.println("상세페이지 리뷰출력 페이징");
		String page = (String) request.getParameter("page");
		String pageDataCount = (String) request.getParameter("pageDataCount");
		// 게시글이 몇개인지 확인하는 쿼리문
		
		// 예외처리
		if (page == null) {
			page = "1";
		}
		if (pageDataCount == null) {
			pageDataCount = "3";
		}
		

		ReviewDao rDao = ReviewDao.getInstance();
		ArrayList<ReviewVO> ReviewdressidList = rDao.selectReviewpageging(page, pageDataCount, dressid);
		request.setAttribute("ReviewdressidList", ReviewdressidList);

		int totalDataCount = ReviewDao.dataCount(dressid);

		ReviewCountDto reviewCountDto = new ReviewCountDto();
		reviewCountDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		request.setAttribute("reviewCountDto", reviewCountDto);
		System.out.println("현제 페이지 넘버 page = " + page);
		System.out.println("한 페이지에 출력할 게시물 개수 pageDataCount = " + pageDataCount);
		System.out.println(dressid +" totalDataCount = " + totalDataCount);
		System.out.println(reviewCountDto);

//--------------------상세페이지 Q&A 리스트 출력-------------------------
		QandADao qDao = QandADao.getInstance();
		dressid = request.getParameter("dressid");
		System.out.println("상세페이지 Q&A 리스트 출력");
		System.out.println("");
		ArrayList<QandAVo> dressDetails = qDao.QandASelete(dressid);
		request.setAttribute("dressDetails", dressDetails);

	}

}

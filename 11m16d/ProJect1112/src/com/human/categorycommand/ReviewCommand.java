package com.human.categorycommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.CartDao;
import com.human.dao.OrderDao;
import com.human.dao.ProDao;
import com.human.dao.ReviewDao;
import com.human.dto.CartVO;
import com.human.dto.ProDto;
import com.human.dto.ReviewCountDto;
import com.human.dto.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewCommand implements ProCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String saveFolder = "C:/sql/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ProJect1112/img/uploadimg";
		final int maxSize = 10 * 1024 * 1024; // 10mb
		try {
			MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			String id = multi.getParameter("id");
			String dressid = multi.getParameter("dressid");

			OrderDao oDao = new OrderDao();
			int result = oDao.checkOrder(id, dressid);
			request.setAttribute("result", result);

			System.out.println("상품 주문여부  " + result + "(Yes=1, No=-1)");
			if (result == 1) {
// -------------------Review ��� ------------------------------------------------

				dressid = multi.getParameter("dressid");
				id = multi.getParameter("id");
				String reviewtitle = multi.getParameter("reviewtitle");
				String reviewcontent = multi.getParameter("reviewcontent");
				String reviewImg = multi.getFilesystemName("reviewImg");
				String reviewscore = multi.getParameter("reviewscore");
				String dressname = multi.getParameter("dressname");
				System.out.println("");
				System.out.println("---------------------------");
				System.out.println("리뷰 등록중.....");
				System.out.println("상품 아이디 : " + dressid);
				System.out.println("상품 이름 : " + dressname);
				System.out.println("주문자 ID : " + id);
				System.out.println("리뷰 타이틀 : " + reviewtitle);
				System.out.println("리뷰 내용 : " + reviewcontent);
				System.out.println("리뷰 이미지 : " + reviewImg);
				System.out.println("상품 점수 : " + reviewscore);
				System.out.println("---------------------------");
				System.out.println("");
				ReviewVO reviewVO = new ReviewVO();
				
				reviewVO.setDressId(Integer.parseInt(dressid));
				reviewVO.setDressname(dressname);
				reviewVO.setId(id);
				reviewVO.setReviewtitle(reviewtitle);
				reviewVO.setReviewcontent(reviewcontent);
				reviewVO.setReviewimg("<img src='../img/uploadimg/" + reviewImg + "'>");
				reviewVO.setReviewscore(reviewscore);
				ReviewDao reviewDao = ReviewDao.getInstance();
				reviewDao.reviewInsert(reviewVO);

// ------------------page pageing---------------------------------------------
				String page = (String)request.getParameter("page");
				String pageDataCount = (String)request.getParameter("pageDataCount");
				// ����ó��
				if(page==null) { 
					page="1";
				}
				if(pageDataCount==null) {
					pageDataCount="3";
				}
			
				ReviewDao rDao = ReviewDao.getInstance();
				ArrayList<ReviewVO> ReviewdressidList = rDao.selectReviewpageging(page, pageDataCount, dressid);
				request.setAttribute("ReviewdressidList", ReviewdressidList);
			
				// 상품 넘버를 받아와 그 상품의 리뷰 개수를 확인
				int totalDataCount=ReviewDao.dataCount(dressid);
				
				ReviewCountDto reviewCountDto = new ReviewCountDto();
				reviewCountDto.makePage(Integer.parseInt(page),Integer.parseInt(pageDataCount),totalDataCount);
				request.setAttribute("reviewCountDto", reviewCountDto);
				System.out.println("현제 페이지 넘버 page = " + page);
				System.out.println("한 페이지에 출력할 게시물 개수 pageDataCount = " + pageDataCount);
				System.out.println(dressid +" totalDataCount = " + totalDataCount);
				System.out.println(reviewCountDto);
//-----------------------------상세페이지 열기 ------------------------------
				ProDao dao = new ProDao();
				ProDto dto = dao.select(dressid);
				request.setAttribute("dto", dto);
				
//---------------------�α����� ���� dressid ��ǰ�� �ֹ� �� �����Ͱ� ���ٸ� �Ʒ� �ڵ� ����-----------
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('상품 주문을 먼저해야 리뷰 가능.');history.go(-1);</script>");
				writer.close();
			
				ProDao dao = new ProDao();
				ProDto dto = dao.select(dressid);
				request.setAttribute("dto", dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

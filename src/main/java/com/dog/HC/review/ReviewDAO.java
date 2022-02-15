package com.dog.HC.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.member.Member;
import com.dog.HC.schoolmain.postscript;
import com.dog.HC.schoolmain.postscriptmapper;

@Service
public class ReviewDAO {
	
	int TotalCount = 0;

	@Autowired
	private SqlSession ss;
	
	public void getTotal() {	 
		 ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		 TotalCount = mm.getreviewTotalCount();              
	}
	 
	public void pageView(review r, HttpServletRequest req) {
		String strPg = req.getParameter("pg");
		
		int rowSize = 5; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	    
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	    
	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
	    
	    r.setR_da_no(from);
	    r.setR_no(to);
	    
	    
	    ReviewMapper mm = ss.getMapper(ReviewMapper.class);
	    List<review> reviews = mm.getAllreview(r);
		req.setAttribute("reviews", reviews);
 
	}
	
	public void page(review r, HttpServletRequest req) {
		String strPg = req.getParameter("pg");
	   	 
	    int rowSize = 5; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = TotalCount; //총 게시물 수
	    int allPage = (int) Math.ceil(total/(double)rowSize); //페이지수
	    int block = 5; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>

	    int fromPage = ((pg-1)/block*block)+1;  //보여줄 페이지의 시작
	    int toPage = ((pg-1)/block*block)+block; //보여줄 페이지의 끝
	    if(toPage> allPage){ // 예) 20>17
	        toPage = allPage;
	    }

	    req.setAttribute("pg", pg);
	    req.setAttribute("block", block);
	    req.setAttribute("fromPage", fromPage);
	    req.setAttribute("toPage", toPage);
	    req.setAttribute("allPage", allPage);
	    req.setAttribute("rowSize", rowSize);
	    req.setAttribute("TotalCount", total);
	}
	
/*
	public void getAllreview(review r, HttpServletRequest req) {
		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		List<review> reviews = mm.getAllreview();
		req.setAttribute("reviews", reviews);
		
	}
*/
	public void getWrite(review r, HttpServletRequest req) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		int r_da_no = 1;
		String r_id = m.getName();
		
		r.setR_da_no(r_da_no);
		r.setR_id(r_id);
	    
		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		if(mm.reviewWrite(r) == 1){
			System.out.println("등록성공");
			req.getSession().setAttribute("successToken", token);
		}else {
			System.out.println("등록실패");
		}
		
		
	}

	public void getreview(review r, HttpServletRequest req) {
		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		review review = mm.getreview(r);
		req.setAttribute("rv", review);
		
	}

	public int reviewDelete(review r, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		String r_name = m.getName();
		r.setR_id(r_name);

		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		if(mm.reviewDelete(r) == 1){
			System.out.println("삭제성공");
			return 1;
		}else {
			System.out.println("삭제실패");
			return 0;
		}
	}

	public void reviewUpdate(review r, HttpServletRequest req) {
		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		if(mm.reviewUpdate(r) == 1){
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
		
		
	}
	
	public void getfivereview(review r, HttpServletRequest req) {
		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		List<review> fivepostscript = mm.getfivereview(r);
		req.setAttribute("fivepostscript", fivepostscript);
		
	}
		

}

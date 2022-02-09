package com.dog.HC.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.member.Member;

@Service
public class ReviewDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllreview(review r, HttpServletRequest req) {
		ReviewMapper mm = ss.getMapper(ReviewMapper.class);
		List<review> reviews = mm.getAllreview();
		req.setAttribute("reviews", reviews);
		
	}

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
		

}

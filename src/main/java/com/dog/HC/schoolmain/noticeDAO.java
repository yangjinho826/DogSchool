package com.dog.HC.schoolmain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dog.HC.member.Member;

@Service
public class noticeDAO {
	
	int TotalCount = 0;
	
	@Autowired
	private SqlSession ss;
	
	 public void getTotal() {	 
		 noticemapper mm = ss.getMapper(noticemapper.class);
		 TotalCount = mm.getNoticeTotalCount();              
	}
	 
	public void pageView(notice n, HttpServletRequest req) {
		String strPg = req.getParameter("pg");
		
		int rowSize = 3; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	    
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	    
	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
	    
	    n.setN_da_no(from);
	    n.setN_no(to); 
	    
	    noticemapper mm = ss.getMapper(noticemapper.class);
		List<notice> notices = mm.getAllnotice(n);
		req.setAttribute("notices", notices);
	}
	
	public void page(notice n, HttpServletRequest req) {
		String strPg = req.getParameter("pg");
	   	 
	    int rowSize = 3; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = TotalCount; //총 게시물 수
	    int allPage = (int) Math.ceil(total/(double)rowSize); //페이지수
	    int block = 10; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>

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
	public void getAllnotice(notice n, HttpServletRequest req) {
		noticemapper mm = ss.getMapper(noticemapper.class);
		List<notice> notices = mm.getAllnotice(n);
		req.setAttribute("notices", notices);
	}
*/
	public void getWrite(notice n, HttpServletRequest req) {
		
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
				
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		int n_da_no = 1;
		String n_id = m.getName();
		
		n.setN_da_no(n_da_no);
		n.setN_id(n_id);
	    
		noticemapper mm = ss.getMapper(noticemapper.class);
		if(mm.noticeWrite(n) == 1){
			System.out.println("등록성공");
			req.getSession().setAttribute("successToken", token);
		}else {
			System.out.println("등록실패");
		}
		
	}

	public void getnotice(notice n, HttpServletRequest req) {
		noticemapper mm = ss.getMapper(noticemapper.class);
		notice note = mm.getnotice(n);
		req.setAttribute("note", note);
		
	}

	public int noticeTDelete(notice n, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		String n_name = m.getName();
		n.setN_id(n_name);
		
		noticemapper mm = ss.getMapper(noticemapper.class);
		if(mm.noticeTDelete(n) == 1){
			System.out.println("삭제성공");
			return 1;
		}else {
			System.out.println("삭제실패");
			return 0;
		}
		
	}
	
	public int noticeDDelete(notice n, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		String n_name = m.getName();
		n.setN_id(n_name);
		
		noticemapper mm = ss.getMapper(noticemapper.class);
		if(mm.noticeDDelete(n) == 1){
			System.out.println("삭제성공");
			return 1;
		}else {
			System.out.println("삭제실패");
			return 0;
		}
	}
	

	public void noticeUpdate(notice n, HttpServletRequest req) {
		
		noticemapper mm = ss.getMapper(noticemapper.class);
		if(mm.noticeUpdate(n) == 1){
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
		
	}

	public void getfivenotice(notice n, HttpServletRequest req) {
		noticemapper mm = ss.getMapper(noticemapper.class);
		List<notice> fivenote = mm.getfivenotice(n);
		req.setAttribute("fivenote", fivenote);
		
	}


	
}

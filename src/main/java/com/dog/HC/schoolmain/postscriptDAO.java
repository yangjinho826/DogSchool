package com.dog.HC.schoolmain;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplySchool;
import com.dog.HC.member.Member;

@Service
public class postscriptDAO {
	
	int TotalCount = 0;
	
	@Autowired
	private SqlSession ss;
	
	 public void getpTotal(postscript p, HttpServletRequest req) {
		 ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		 
		 p.setP_da_no(as.getDa_no());
		 
		 postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		 TotalCount = mm.getpostscripTotalCount(p);              
	}
	 
	public void ppageView(postscript p, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		String strPg = req.getParameter("pg");
		
		int rowSize = 3; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	    
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	    
	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
	    
	    p.setP_da_no(as.getDa_no());
	    p.setFrom(from);
	    p.setTo(to);
	    
	    
	    postscriptmapper mm = ss.getMapper(postscriptmapper.class);
	    List<postscript> postscripts = mm.getAllpostscript(p);
		req.setAttribute("postscripts", postscripts);
  
	}
	
	public void ppage(postscript p, HttpServletRequest req) {
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

	public void getWrite(postscript p, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		 
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		int p_da_no = as.getDa_no();
		String p_id = m.getName();
		
		p.setP_da_no(p_da_no);
		p.setP_id(p_id);
	    
		postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		if(mm.postscriptWrite(p) == 1){
			System.out.println("등록성공");
			req.getSession().setAttribute("successToken", token);
		}else {
			System.out.println("등록실패");
		}
		
	}
	
	public void getpostscript(postscript p, HttpServletRequest req) {
		postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		postscript postcript = mm.getpostscript(p);
		req.setAttribute("ps", postcript);
		
	}

	public int postscriptDelete(postscript p, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		String p_name = m.getName();
		p.setP_id(p_name);
		
		postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		if(mm.postscriptDelete(p) == 1){
			System.out.println("삭제성공");
			return 1;
		}else {
			System.out.println("삭제실패");
			return 0;
		}
		
		
	}

	public void postscriptUpdate(postscript p, HttpServletRequest req) {
		
		postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		if(mm.postscriptUpdate(p) == 1){
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
		
		
	}

	public void getfivepostscript(postscript p, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		p.setP_da_no(as.getDa_no());
		
		postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		List<postscript> fivepostscript = mm.getfivepostscript(p);
		req.setAttribute("fivepostscript", fivepostscript);
		
	}
	
	
	
}

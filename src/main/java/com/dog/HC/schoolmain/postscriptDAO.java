package com.dog.HC.schoolmain;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.member.Member;

@Service
public class postscriptDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void getAllpostscript(postscript p, HttpServletRequest req) {
		
		postscriptmapper mm = ss.getMapper(postscriptmapper.class);
		List<postscript> postscripts = mm.getAllpostscript();
		req.setAttribute("postscripts", postscripts);
		
	
	}

	public void getWrite(postscript p, HttpServletRequest req) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		int p_da_no = 1;
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
	
	
	
}

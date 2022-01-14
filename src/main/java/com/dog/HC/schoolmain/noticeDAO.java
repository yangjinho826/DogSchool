package com.dog.HC.schoolmain;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class noticeDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAllnotice(notice n, HttpServletRequest req) {
		
		noticemapper mm = ss.getMapper(noticemapper.class);
		List<notice> notices = mm.getAllnotice();
		req.setAttribute("notices", notices);
	}

	public void getWrite(notice n, HttpServletRequest req) {
		
		int n_da_no = 1;
		String n_id = "작성용 아이디";
		
		n.setN_da_no(n_da_no);
		n.setN_id(n_id);
	    
		noticemapper mm = ss.getMapper(noticemapper.class);
		if(mm.noticeWrite(n) == 1){
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
		
	}

	public void getnotice(notice n, HttpServletRequest req) {
		noticemapper mm = ss.getMapper(noticemapper.class);
		notice note = mm.getnotice(n);
		req.setAttribute("note", note);
		
	}

	public void noticeDelete(notice n, HttpServletRequest req) {
		noticemapper mm = ss.getMapper(noticemapper.class);
		if(mm.noticeDelete(n) == 1){
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
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
	
	
}

package com.dog.HC.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplyMapper;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;

@Service
public class ManageDAO {
	@Autowired
	private SqlSession ss;
	
	//승인된 유치원 조회
	public void getAllSchool(HttpServletRequest req) {
		try {
			req.setAttribute("passSchools", ss.getMapper(ManageMapper.class).getAllSchool());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//관리자가 등록된 유치원 삭제(사이트 이용 불가)
	public void deleteSchool(ApplySchool s, HttpServletRequest req) {
		s.setDa_no(Integer.parseInt(req.getParameter("Da_no")));
		if (ss.getMapper(ManageMapper.class).deleteSchool(s) == 1) {
			System.out.println("유치원 삭제 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("유치원 삭제 실패");
		}
	}


	public void getAllTeacher(HttpServletRequest req) {
		try {
			req.setAttribute("passTeachers", ss.getMapper(ManageMapper.class).getAllTeacher());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.dog.HC.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplyMapper;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.member.Member;

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
	//승인된 선생님 조회
	public void getAllTeacher(HttpServletRequest req) {
		try {
			req.setAttribute("passTeachers", ss.getMapper(ManageMapper.class).getAllTeacher());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//승인된 유저(강아지) 조회
	public void getAllPet(HttpServletRequest req) {
		try {
			req.setAttribute("passPets", ss.getMapper(ManageMapper.class).getAllPet());
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

	//타입 반환
	public void getType(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try{
			req.setAttribute("getType", ss.getMapper(ManageMapper.class).getType(m));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//주체자 입장에서 승인한 목록 전체 조회
	public void getMyTeacher(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myPassTeachers", ss.getMapper(ManageMapper.class).getMyTeacher(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getMyPet(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myPassPets", ss.getMapper(ManageMapper.class).getMyPet(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

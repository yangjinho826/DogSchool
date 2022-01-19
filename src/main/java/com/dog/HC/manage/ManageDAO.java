package com.dog.HC.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplySchool;

@Service
public class ManageDAO {
	@Autowired
	private SqlSession ss;
	
	//승인된 유치원 조회
	public void getAllSchool(ApplySchool s, HttpServletRequest req) {
		try {
			req.setAttribute("passSchools", ss.getMapper(ManageMapper.class).getAllSchool());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	

}

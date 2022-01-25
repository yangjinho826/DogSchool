package com.dog.HC.Yuchiwon;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllDiary(HttpServletRequest req, diary d) {
		req.setAttribute("diaries", ss.getMapper(YuchiwonMapper.class).getAllDiary());
	}

	public void getWrite(HttpServletRequest req, diary d) {
		int mp_da_no;
		String mp_id;
		
		
	}
}

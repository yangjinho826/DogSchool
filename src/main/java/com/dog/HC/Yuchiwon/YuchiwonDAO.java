package com.dog.HC.Yuchiwon;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YuchiwonDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllPuppy(HttpServletRequest req) {
		req.setAttribute("puppies", ss.getMapper(YuchiwonMapper.class).getAllPuppy());
	}

	public void getPuppy(HttpServletRequest req, puppy puppy) {
		
		req.setAttribute("puppie", ss.getMapper(YuchiwonMapper.class).getPuppy(puppy));
		
	}
}

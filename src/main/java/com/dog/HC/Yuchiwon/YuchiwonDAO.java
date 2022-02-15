package com.dog.HC.Yuchiwon;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;

@Service
public class YuchiwonDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllPuppy(HttpServletRequest req, signup s) {
		
		Map<String, String> aa = new HashMap<String, String>();
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("typee"));
		
		aa.put("iddd", req.getParameter("id"));
		aa.put("typeee", req.getParameter("typee"));
		
		req.setAttribute("puppies", ss.getMapper(YuchiwonMapper.class).getAllPuppy(aa));
	}

	public void getPuppy(HttpServletRequest req, puppy puppy) {
		
		req.getSession().setAttribute("puppies", ss.getMapper(YuchiwonMapper.class).getPuppy(puppy));
		req.getSession().setMaxInactiveInterval(60 * 5);
		
	}
}

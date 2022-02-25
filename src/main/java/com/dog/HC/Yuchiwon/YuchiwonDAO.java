package com.dog.HC.Yuchiwon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;

import com.dog.HC.manage.ManageDAO;

@Service
public class YuchiwonDAO {

	@Autowired
	private SqlSession ss;

	public void getAllPuppy(HttpServletRequest req, signup s) {
		
		Map<String, String> aa = new HashMap<String, String>();

		aa.put("iddd", req.getParameter("id"));
		aa.put("typeee", req.getParameter("typee"));
		
		YuchiwonMapper mm = ss.getMapper(YuchiwonMapper.class);
		List<puppy> puppies = mm.getAllPuppy(aa);
		
		req.setAttribute("puppies", puppies);
	}

	public void getPuppy(HttpServletRequest req, puppy puppy) {
		
		req.getSession().setAttribute("puppies", ss.getMapper(YuchiwonMapper.class).getPuppy(puppy));
		req.getSession().setMaxInactiveInterval(60 * 5);
		
	}
}

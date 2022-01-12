package com.dog.HC.Yuchiwon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class YuchiwonC {
	@Autowired
	private YuchiwonDAO ydao;

	@RequestMapping(value = "yuchiwon.get.allpuppy", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		ydao.getAllPuppy(req);
		req.setAttribute("yuchiwonContent", "puppyList.jsp");
		return "yuchiwon/sy";
	}

	
	@RequestMapping(value = "yuchiwon.get", method = RequestMethod.GET)
	public String homeedv(HttpServletRequest req) {
		
		req.setAttribute("yuchiwonContent", "yhomejsp");
		return "yuchiwon/sy";
	}
	
}

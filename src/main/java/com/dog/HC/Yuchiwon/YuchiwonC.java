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
	public String pList(HttpServletRequest req) {
		ydao.getAllPuppy(req);
		req.setAttribute("yuchiwonContent", "puppyList.jsp");
		return "yuchiwon/yuchiwon";
	}

	
	@RequestMapping(value = "yuchiwon.get", method = RequestMethod.GET)
	public String yhome(HttpServletRequest req) {
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("yuchiwonContent", "yhome.jsp");
		return "yuchiwon/yuchiwon";
	}
	

	@RequestMapping(value = "yuchiwon.get.puppy", method = RequestMethod.GET)
	public String getPuppy(HttpServletRequest req, puppy puppy) {
		ydao.getPuppy(req, puppy);
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("yuchiwonContent", "yPuppy.jsp");
		return "yuchiwon/puppyPage";
	}
	
	@RequestMapping(value = "yuchiwon.get.diary", method = RequestMethod.GET)
	public String puppyDiary(HttpServletRequest req, puppy puppy) {
		ydao.getPuppy(req, puppy);
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("puppyContent", "pDiary.jsp");
		return "yuchiwon/puppyPage";
	}

}

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
	
	@Autowired
	private DiaryDAO ddao;

	
	@RequestMapping(value = "yuchiwon.get", method = RequestMethod.GET)
	public String yhome(HttpServletRequest req) {
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("yuchiwonContent", "yhome.jsp");
		return "yuchiwon/yuchiwon";
	}
	
	@RequestMapping(value = "yuchiwon.get.allpuppy", method = RequestMethod.GET)
	public String pList(HttpServletRequest req) {
		ydao.getAllPuppy(req);
		req.setAttribute("yuchiwonContent", "puppyList.jsp");
		return "yuchiwon/yuchiwon";
	}

	@RequestMapping(value = "yuchiwon.get.puppy", method = RequestMethod.GET)
	public String getPuppy(HttpServletRequest req, puppy puppy) {
		ydao.getPuppy(req, puppy);
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("yuchiwonContent", "yPuppy.jsp");
		return "yuchiwon/puppyPage";
	}
	
	// 알림장
	@RequestMapping(value = "yuchiwon.get.diary", method = RequestMethod.GET)
	public String diarygo(HttpServletRequest req, puppy puppy) {
		ydao.getPuppy(req, puppy);
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("puppyContent", "diary_home.jsp");
		return "yuchiwon/puppyPage";
	}

	@RequestMapping(value = "diary.write.go", method = RequestMethod.GET)
	public String diarywritego(HttpServletRequest req) {
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("puppyContent", "diary_write.jsp");
		return "yuchiwon/puppyPage";
	}

	@RequestMapping(value = "diary.write", method = RequestMethod.GET)
	public String diarywrite(HttpServletRequest req, diary d) {
		
		ddao.getWrite(req, d);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("loginPage", "../main/loginPage.jsp");
		req.setAttribute("puppyContent", "diary_home.jsp");
		return "yuchiwon/puppyPage";
	}
	
}

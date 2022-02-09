package com.dog.HC.Yuchiwon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dog.HC.member.MemberDAO;

@Controller
public class YuchiwonC {
	
	@Autowired
	private YuchiwonDAO ydao;
	
	@Autowired
	private DiaryDAO ddao;

	@Autowired
	private MemberDAO mDAOO;
	
	@RequestMapping(value = "yuchiwon.get.allpuppy", method = RequestMethod.GET)
	public String pList(HttpServletRequest req, signup s) {
		if(mDAOO.loginCheck(req)) {
			ydao.getAllPuppy(req, s);
		}
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/puppyList.jsp");
		req.setAttribute("footer", "main/footer.jsp");
	
		return "index";
	}

	@RequestMapping(value = "yuchiwon.get.puppy", method = RequestMethod.GET)
	public String getPuppy(HttpServletRequest req, puppy puppy) {
		mDAOO.loginCheck(req);
		ydao.getPuppy(req, puppy);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/puppyPage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
	
		
		return "index";
	}
	
	// 알림장
	@RequestMapping(value = "yuchiwon.get.diary", method = RequestMethod.GET)
	public String diarygo(HttpServletRequest req, puppy puppy, diary d) {
		mDAOO.loginCheck(req);
		//ydao.getPuppy(req, puppy);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.write.go", method = RequestMethod.GET)
	public String diarywritego(HttpServletRequest req) {
		mDAOO.loginCheck(req);

		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		
		return "index";
	}

	@RequestMapping(value = "diary.write", method = RequestMethod.GET)
	public String diarywrite(HttpServletRequest req, diary d) {
		mDAOO.loginCheck(req);
		ddao.writeDiary(req, d);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "diary.reply.write", method = RequestMethod.GET)
	public String diaryreplywrite(HttpServletRequest req, diaryReply dr, diary d) {
		mDAOO.loginCheck(req);
		ddao.writeReply(req, dr);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.update.go", method = RequestMethod.GET)
	public String diaryupdatego(HttpServletRequest req, diaryReply dr, diary d) {
		mDAOO.loginCheck(req);
		ddao.getDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_update.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.update", method = RequestMethod.GET)
	public String diaryupdate(HttpServletRequest req, diary d) {
		if (mDAOO.loginCheck(req)) {
			ddao.updateDiary(req, d);
		}
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "diary.delete", method = RequestMethod.GET)
	public String diarydelete(HttpServletRequest req, diary d) {
		if (mDAOO.loginCheck(req)) {
			ddao.deleteDiary(req, d);
		}
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.reply.delete", method = RequestMethod.GET)
	public String replydelete(HttpServletRequest req, diaryReply dr, diary d) {
		if (mDAOO.loginCheck(req)) {
			ddao.deleteReply(req, dr);
		}
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}


}

package com.dog.HC.schoolmain;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dog.HC.TokenMaker;
import com.dog.HC.member.MemberDAO;

@Controller
public class schoolmainController {
	
	@Autowired
	private noticeDAO nDAO;
	
	@Autowired
	private postscriptDAO pDAO;
	
	@Autowired
	private priceTagDAO pTDAO;
	
	@Autowired
	private scheduleDAO sDAO;
	
	@Autowired
	private MemberDAO mDAOO;
	
	@RequestMapping(value = "schoolmain.go", method = RequestMethod.GET)
	public String schoolmain(notice n, postscript p,priceTag pT, schedule s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		nDAO.getfivenotice(n, req);
		pDAO.getfivepostscript(p, req);
		pTDAO.getAllpriceTag(pT, req);
		sDAO.getmonschedule(s, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/Schoolhome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	// 공지사항 
	@RequestMapping(value = "notice.go", method = RequestMethod.GET)
	public String notice(notice n, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		nDAO.getTotal();
		nDAO.pageView(n, req);
		nDAO.page(n, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice_write.go", method = RequestMethod.GET)
	public String noticewirtego(notice n, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.write", method = RequestMethod.GET)
	public String noticewirte(notice n, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		nDAO.getWrite(n, req);
		nDAO.getTotal();
		nDAO.pageView(n, req);
		nDAO.page(n, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.Detail", method = RequestMethod.GET)
	public String noticeDetail(notice n, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		nDAO.getnotice(n, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.DDelete", method = RequestMethod.GET)
	public @ResponseBody int noticeDDelete(notice n, HttpServletRequest req) {
		return nDAO.noticeDDelete(n, req);
	}
	
	@RequestMapping(value = "notice.TDelete", method = RequestMethod.GET)
	public @ResponseBody int noticeTDelete(notice n, HttpServletRequest req) {
		
		return nDAO.noticeTDelete(n, req);
	}
	
	@RequestMapping(value = "notice.UpdatePageGo", method = RequestMethod.GET)
	public String noticeUpdatePage(notice n, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		nDAO.getnotice(n, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_updatePage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.update", method = RequestMethod.POST)
	public String noticeUpdate(notice n, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		nDAO.noticeUpdate(n, req);
		nDAO.getnotice(n, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	// 선생님 후기
	
	@RequestMapping(value = "postscript.go", method = RequestMethod.GET)
	public String postscript(postscript p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pDAO.getpTotal();
		pDAO.ppageView(p, req);
		pDAO.ppage(p, req);
		
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript_write.go", method = RequestMethod.GET)
	public String postscriptwirtego(postscript p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.write", method = RequestMethod.POST)
	public String postscriptwirte(postscript p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pDAO.getWrite(p, req);
		pDAO.getpTotal();
		pDAO.ppageView(p, req);
		pDAO.ppage(p, req);
		
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.Detail", method = RequestMethod.GET)
	public String postscriptDetail(postscript p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pDAO.getpostscript(p, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.Delete", method = RequestMethod.GET)
	public @ResponseBody int postscriptDelete(postscript p, HttpServletRequest req) {

		return 	pDAO.postscriptDelete(p, req);
	}
	
	@RequestMapping(value = "postscript.UpdatePageGo", method = RequestMethod.GET)
	public String postscriptUpdatePage(postscript p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pDAO.getpostscript(p, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_updatePage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "postscript.update", method = RequestMethod.POST)
	public String postscriptUpdate(postscript p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pDAO.postscriptUpdate(p, req);
		pDAO.getpostscript(p, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
	// 가격표
	@RequestMapping(value = "priceTag.go", method = RequestMethod.GET)
	public String priceTaggo(priceTag pT, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "priceTag_write.go", method = RequestMethod.GET)
	public String pricewritego(priceTag pT, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		return "schoolmain/priceTag_write";
	}
	
	@RequestMapping(value = "priceTag.write", method = RequestMethod.GET)
	public String priceTagwirte(priceTag pT, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pTDAO.getWrite(pT, req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "priceTag_Detail", method = RequestMethod.GET)
	public String priceTaDetail(priceTag pT, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pTDAO.getpriceTag(pT, req);
		
		return "schoolmain/priceTag_Detail";
	}
	
	@RequestMapping(value = "priceTag.Delete", method = RequestMethod.GET)
	public String priceTagDelete(priceTag pT, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pTDAO.priceTagDelete(pT, req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");

		return "index";
		
	}
	
	@RequestMapping(value = "priceTag.Update", method = RequestMethod.GET)
	public String priceTagUpdate(priceTag pT, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		pTDAO.priceTagUpdate(pT, req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");

		return "index";
		
	}
	
	// 스케줄
	@RequestMapping(value = "schedule.go", method = RequestMethod.GET)
	public String schedulemain(schedule s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		sDAO.getAllschedule(s, req);
	
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/schedule_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "sechdule_write.go", method = RequestMethod.GET)
	public String schedulewritego(schedule s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		return "schoolmain/schedule_write";
	}
	
	@RequestMapping(value = "schedule.write", method = RequestMethod.GET)
	public String schedulewirte(schedule s, HttpServletRequest req) throws ParseException {
		mDAOO.loginCheck(req);
		sDAO.getschedulewirte(s, req);
		sDAO.getAllschedule(s, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/schedule_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "schedule_Detail", method = RequestMethod.GET)
	public String scheduleDetail(schedule s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		sDAO.getschedule(s, req);
		
		return "schoolmain/schedule_Detail";
	}
	
	@RequestMapping(value = "schedule.update", method = RequestMethod.GET)
	public String scheduleUpdate(schedule s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		sDAO.scheduleUpdate(s, req);
		sDAO.getAllschedule(s, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/schedule_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");

		return "index";
		
	}
	@RequestMapping(value = "schedule.Delete", method = RequestMethod.GET)
	public String scheduleDelete(schedule s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		sDAO.scheduleDelete(s, req);
		sDAO.getAllschedule(s, req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/schedule_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");

		return "index";
		
	}
}

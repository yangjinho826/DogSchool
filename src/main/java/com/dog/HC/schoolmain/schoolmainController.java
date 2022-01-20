package com.dog.HC.schoolmain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class schoolmainController {
	
	@Autowired
	private noticeDAO nDAO;
	
	@Autowired
	private postscriptDAO pDAO;
	
	@Autowired
	private priceTagDAO pTDAO;
	
	@RequestMapping(value = "schoolmain.go", method = RequestMethod.GET)
	public String schoolmain(notice n, HttpServletRequest req) {
		
	
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	// 공지사항 
	@RequestMapping(value = "notice.go", method = RequestMethod.GET)
	public String notice(notice n, HttpServletRequest req) {
		
		nDAO.getAllnotice(n, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice_write.go", method = RequestMethod.GET)
	public String noticewirtego(notice n, HttpServletRequest req) {
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.write", method = RequestMethod.POST)
	public String noticewirte(notice n, HttpServletRequest req) {
		
		nDAO.getWrite(n, req);
		nDAO.getAllnotice(n, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.Detail", method = RequestMethod.GET)
	public String noticeDetail(notice n, HttpServletRequest req) {
		
		nDAO.getnotice(n, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.Delete", method = RequestMethod.GET)
	public String noticeDelete(notice n, HttpServletRequest req) {
		
		nDAO.noticeDelete(n, req);
		nDAO.getAllnotice(n, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.UpdatePageGo", method = RequestMethod.GET)
	public String noticeUpdatePage(notice n, HttpServletRequest req) {
		
		nDAO.getnotice(n, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_updatePage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "notice.update", method = RequestMethod.POST)
	public String noticeUpdate(notice n, HttpServletRequest req) {
		
		nDAO.noticeUpdate(n, req);
		nDAO.getnotice(n, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/notice_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	// 선생님 후기
	
	@RequestMapping(value = "postscript.go", method = RequestMethod.GET)
	public String postscript(postscript p, HttpServletRequest req) {
		
		pDAO.getAllpostscript(p, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript_write.go", method = RequestMethod.GET)
	public String postscriptwirtego(postscript p, HttpServletRequest req) {
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.write", method = RequestMethod.POST)
	public String postscriptwirte(postscript p, HttpServletRequest req) {
		
		pDAO.getWrite(p, req);
		pDAO.getAllpostscript(p, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.Detail", method = RequestMethod.GET)
	public String postscriptDetail(postscript p, HttpServletRequest req) {
		
		pDAO.getpostscript(p, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.Delete", method = RequestMethod.GET)
	public String postscriptDelete(postscript p, HttpServletRequest req) {
		
		pDAO.postscriptDelete(p, req);
		pDAO.getAllpostscript(p, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "postscript.UpdatePageGo", method = RequestMethod.GET)
	public String postscriptUpdatePage(postscript p, HttpServletRequest req) {
		
		pDAO.getpostscript(p, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_updatePage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "postscript.update", method = RequestMethod.POST)
	public String postscriptUpdate(postscript p, HttpServletRequest req) {
		
		pDAO.postscriptUpdate(p, req);
		pDAO.getpostscript(p, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/postscript_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
	// 가격표
	@RequestMapping(value = "priceTag.go", method = RequestMethod.GET)
	public String priceTaggo(priceTag pT, HttpServletRequest req) {
		
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "priceTag_write.go", method = RequestMethod.GET)
	public String pricewritego(priceTag pT, HttpServletRequest req) {
		
		return "schoolmain/priceTag_write";
	}
	
	@RequestMapping(value = "priceTag.write", method = RequestMethod.GET)
	public String priceTagwirte(priceTag pT, HttpServletRequest req) {
		
		pTDAO.getWrite(pT, req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "priceTag_Detail", method = RequestMethod.GET)
	public String priceTaDetail(priceTag pT, HttpServletRequest req) {
		
		pTDAO.getpriceTag(pT, req);
		
		return "schoolmain/priceTag_Detail";
	}
	
	@RequestMapping(value = "priceTag.Delete", method = RequestMethod.GET)
	public String priceTagDelete(priceTag pT, HttpServletRequest req) {
		
		pTDAO.priceTagDelete(pT, req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");

		return "index";
		
	}
	
	@RequestMapping(value = "priceTag.Update", method = RequestMethod.GET)
	public String priceTagUpdate(priceTag pT, HttpServletRequest req) {
		
		pTDAO.priceTagUpdate(pT, req);
		pTDAO.getAllpriceTag(pT, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "schoolmain/priceTag_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");

		return "index";
		
	}
}

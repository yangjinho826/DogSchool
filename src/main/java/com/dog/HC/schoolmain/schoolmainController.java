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
	
	@RequestMapping(value = "schoolmain.go", method = RequestMethod.GET)
	public String schoolmain(notice n, HttpServletRequest req) {
		
	
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	

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

}

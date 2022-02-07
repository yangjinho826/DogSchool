package com.dog.HC.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "member.login", method = RequestMethod.POST)
	public String home(HttpServletRequest req , Member m) {
		mDAO.login(req, m);
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, Member m) {
		
		mDAO.logout(req);
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.signup", method = RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/signup.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.signupgo", method = RequestMethod.GET)
	public String signupgo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/signupgo.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.usignup", method = RequestMethod.POST)
	public String usignup(HttpServletRequest req, Member m) {
		
		mDAO.usingup(req, m);
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.info", method = RequestMethod.GET)
	public String memberInfo(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			req.setAttribute("MenuBar", "main/menu.jsp");
			req.setAttribute("contentPage", "member/info.jsp");
			req.setAttribute("footer", "main/footer.jsp");
		} else {
			req.setAttribute("MenuBar", "main/menu.jsp");
			req.setAttribute("contentPage", "main/home.jsp");
			req.setAttribute("footer", "main/footer.jsp");
		}
		return "index";
	}
	
	
	@RequestMapping(value = "member.update", method = RequestMethod.POST)
	public String memberUpdate(HttpServletRequest req, Member m) {
		if (mDAO.loginCheck(req)) {
			mDAO.update(req, m);
			req.setAttribute("MenuBar", "main/menu.jsp");
			req.setAttribute("contentPage", "member/update.jsp");
			req.setAttribute("footer", "main/footer.jsp");
		} else {
			req.setAttribute("MenuBar", "main/menu.jsp");
			req.setAttribute("contentPage", "main/home.jsp");
			req.setAttribute("footer", "main/footer.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "member.bye", method = RequestMethod.GET)
	public String memberBye(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.bye(req);
		}
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/bye.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findidgo", method = RequestMethod.GET)
	public String findidgo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findidgo.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findid", method = RequestMethod.POST)
	public String findid(HttpServletRequest req, Member m) {
		
		mDAO.findid(req, m);
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findid.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findpwgo", method = RequestMethod.GET)
	public String findpwgo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findpwgo.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findpw", method = RequestMethod.POST)
	public String findpw(HttpServletRequest req, Member m) {
		
		mDAO.findpw(req, m);
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findpw.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.get", 
			method = RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	public @ResponseBody int memberGet(HttpServletRequest req, Member m) {
		return mDAO.getMemberNum(req, m);
	}

	
}

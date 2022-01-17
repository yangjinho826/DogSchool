package com.dog.HC.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		req.setAttribute("contentPage", "main/signup.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.signupgo", method = RequestMethod.GET)
	public String signupgo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/signupgo.jsp");
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
	
	
}

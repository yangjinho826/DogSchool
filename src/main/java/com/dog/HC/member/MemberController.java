package com.dog.HC.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dog.HC.apply.ApplyDAO;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.manage.ManageDAO;
import com.dog.HC.review.ReviewDAO;
import com.dog.HC.review.review;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAOO;
	
	@Autowired
	private ReviewDAO rDAO;
	
	@Autowired
	private ManageDAO mDAO;
	
	@Autowired
	private ApplyDAO aDAO;
	
	@RequestMapping(value = "member.login", method = RequestMethod.POST)
	public String home(ApplySchool s, review r, HttpServletRequest req , Member m) {
		mDAOO.login(req, m);
		mDAOO.loginCheck(req);
		mDAO.getAllSchool(req);
		aDAO.pageView(s, req);
		rDAO.pageView(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.logout", method = RequestMethod.GET)
	public String logout(review r, HttpServletRequest req, Member m) {
		
		mDAOO.logout(req);
		mDAOO.loginCheck(req);
		rDAO.pageView(r, req);
		mDAO.getAllSchool(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.signup", method = RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		
		mDAOO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/signup.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.signupgo", method = RequestMethod.GET)
	public String signupgo(HttpServletRequest req) {
		
		mDAOO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/signupgo.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.usignup", method = RequestMethod.POST)
	public String usignup(ApplySchool s, review r,HttpServletRequest req, Member m) {
		
		mDAOO.usingup(req, m);
		mDAOO.loginCheck(req);
		aDAO.pageView(s, req);
		rDAO.pageView(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.info", method = RequestMethod.GET)
	public String memberInfo(HttpServletRequest req) {
		if (mDAOO.loginCheck(req)) {
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
		if (mDAOO.loginCheck(req)) {
			mDAOO.update(req, m);
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
		if (mDAOO.loginCheck(req)) {
			mDAOO.bye(req);
		}
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/bye.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findidgo", method = RequestMethod.GET)
	public String findidgo(HttpServletRequest req) {
		
		mDAOO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findidgo.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findid", method = RequestMethod.POST)
	public String findid(HttpServletRequest req, Member m) {
		
		mDAOO.findid(req, m);
		mDAOO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findid.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findpwgo", method = RequestMethod.GET)
	public String findpwgo(HttpServletRequest req) {
		
		mDAOO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findpwgo.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.findpw", method = RequestMethod.POST)
	public String findpw(HttpServletRequest req, Member m) {
		
		mDAOO.findpw(req, m);
		mDAOO.loginCheck(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "member/findpw.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.get", 
			method = RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	public @ResponseBody int memberGet(HttpServletRequest req, Member m) {
		return mDAOO.getMemberNum(req, m);
	}
	

}

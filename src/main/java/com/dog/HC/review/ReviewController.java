package com.dog.HC.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dog.HC.TokenMaker;
import com.dog.HC.apply.ApplyDAO;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.manage.ManageDAO;
import com.dog.HC.member.Member;
import com.dog.HC.member.MemberDAO;


@Controller
public class ReviewController {
	
	@Autowired
	private ManageDAO mDAO;
	
	@Autowired
	private MemberDAO mDAOO;
	
	@Autowired
	private ReviewDAO rDAO;
	
	@Autowired
	private ApplyDAO aDAO;
	
	
	@RequestMapping(value = "review.go", method = RequestMethod.GET)
	public String review(review r, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		rDAO.getTotal();
		rDAO.pageView(r, req);
		rDAO.page(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "review/review_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "review_write.go", method = RequestMethod.GET)
	public String reviewwirtego(review r, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "review/review_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "review.write", method = RequestMethod.POST)
	public String reviewwirte(review r, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		rDAO.getWrite(r, req);
		rDAO.getTotal();
		rDAO.pageView(r, req);
		rDAO.page(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "review/review_Home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "review.Detail", method = RequestMethod.GET)
	public String reviewDetail(review r, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		rDAO.getreview(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "review/review_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "review.Delete", method = RequestMethod.GET)
	public @ResponseBody int reviewDelete(review r, HttpServletRequest req) {

		return 	rDAO.reviewDelete(r, req);
	}
	
	@RequestMapping(value = "review.UpdatePageGo", method = RequestMethod.GET)
	public String reviewUpdatePage(review r, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		rDAO.getreview(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "review/review_updatePage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "review.update", method = RequestMethod.POST)
	public String reviewUpdate(review r, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		rDAO.reviewUpdate(r, req);
		rDAO.getreview(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "review/review_Detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
}

package com.dog.HC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dog.HC.manage.ManageDAO;
import com.dog.HC.member.Member;
import com.dog.HC.member.MemberDAO;
import com.dog.HC.review.ReviewDAO;
import com.dog.HC.review.review;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAOO;
	
	@Autowired
	private ManageDAO mDAO;

	@Autowired
	private ReviewDAO rDAO;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(review r,HttpServletRequest req) {
		
		mDAOO.loginCheck(req);
		rDAO.pageView(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "HC.go", method = RequestMethod.GET)
	public String HC(review r, HttpServletRequest req) {
		
		mDAOO.loginCheck(req);
		rDAO.pageView(r, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "list.go", method = RequestMethod.GET)
    public String apply(Member m, HttpServletRequest req) {
        mDAOO.loginCheck(req);
        mDAO.getAllSchool(req);

        req.setAttribute("MenuBar", "main/menu.jsp");
        req.setAttribute("contentPage", "main/schoolList.jsp");
        req.setAttribute("footer", "main/footer.jsp");
        return "index";
    }
}

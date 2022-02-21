package com.dog.HC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dog.HC.apply.ApplyDAO;
import com.dog.HC.apply.ApplyPet;
import com.dog.HC.apply.ApplySchool;
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
	
	@Autowired
	private ApplyDAO aDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ApplySchool s, review r, HttpServletRequest req, ApplyPet ap) {
		
		mDAOO.loginCheck(req);
		aDAO.DeleteDaterange(req, ap);
		aDAO.pageView(s, req);
		rDAO.pageView(r, req);
		mDAO.getAllSchool(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "HC.go", method = RequestMethod.GET)
	public String HC(ApplySchool s, review r, HttpServletRequest req, ApplyPet ap) {
		
		mDAOO.loginCheck(req);
		aDAO.DeleteDaterange(req, ap);
		aDAO.pageView(s, req);
		rDAO.pageView(r, req);
		mDAO.getAllSchool(req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "main/home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "list.go", method = RequestMethod.GET)
    public String apply(ApplySchool s, Member m, HttpServletRequest req) {
        mDAOO.loginCheck(req);
        mDAO.getAllSchool(req);
        aDAO.getTotal();
		aDAO.pageView(s, req);
		aDAO.page(s, req);

        req.setAttribute("MenuBar", "main/menu.jsp");
        req.setAttribute("contentPage", "main/schoolList.jsp");
        req.setAttribute("footer", "main/footer.jsp");
        return "index";
    }
}

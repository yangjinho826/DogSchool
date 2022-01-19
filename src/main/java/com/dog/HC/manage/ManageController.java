package com.dog.HC.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dog.HC.apply.ApplyDAO;
import com.dog.HC.apply.ApplySchool;

@Controller
public class ManageController {
	@Autowired
	private ManageDAO mDAO;
	
	//(관리자) 유치원 관리 페이지로 이동
	@RequestMapping(value = "manage.go", method = RequestMethod.GET)
	public String manageSchool(ApplySchool s, HttpServletRequest req) {
		mDAO.getAllSchool(s, req);
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "manage/manageSchool.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
}

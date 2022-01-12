package com.dog.HC.apply;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplyController {
	@Autowired
	private ApplyDAO aDAO;
	
	@RequestMapping(value = "apply.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "apply.school", method = RequestMethod.GET)
	public String applySchool(ApplySchool s, HttpServletRequest req) {
		aDAO.applySchool(s, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "apply.teacher", method = RequestMethod.GET)
	public String applyTeacher(ApplyTeacher t, HttpServletRequest req) {
		aDAO.applyTeacher(t, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "apply.pet", method = RequestMethod.POST)
	public String applyPet(ApplyPet p, HttpServletRequest req) {
		aDAO.applyPet(p, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "accept.go", method = RequestMethod.GET)
	public String home2(HttpServletRequest req) {
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
}

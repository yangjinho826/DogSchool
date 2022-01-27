package com.dog.HC.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dog.HC.apply.ApplyDAO;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.member.MemberDAO;

@Controller
public class ManageController {
	@Autowired
	private ManageDAO mDAO;
	
	@Autowired
	private MemberDAO mDAOO;
	
	
	//(관리자) 유치원 관리 페이지로 이동
	@RequestMapping(value = "manage.go", method = RequestMethod.GET)
	public String manageSchool(ApplySchool s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		mDAO.getAllSchool(req);
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "manage/manageSchool.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//(관리자) 시스템 이용 중인 유치원 삭제
	@RequestMapping(value = "manage.delete", method = RequestMethod.GET)
	public String deleteSchool(ApplySchool s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		mDAO.deleteSchool(s, req); //삭제 후
		mDAO.getAllSchool(req); //다시 조회
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "manage/manageSchool.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}

}

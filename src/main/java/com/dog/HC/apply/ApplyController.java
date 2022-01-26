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

import com.dog.HC.manage.ManageDAO;

@Controller
public class ApplyController {
	@Autowired
	private ApplyDAO aDAO;
	
	@Autowired
	private ManageDAO mDAO;
	
	//신청하는 폼으로 이동
	@RequestMapping(value = "apply.go", method = RequestMethod.GET)
	public String apply(ApplySchool s, ApplyTeacher t, HttpServletRequest req) {
		mDAO.getAllSchool(req);
		mDAO.getAllTeacher(req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//유치원 선택 후 견주 등록하는 폼으로 이동
	@RequestMapping(value = "apply.go.pet", method = RequestMethod.GET)
	public String applyGoPet(ApplySchool s, ApplyTeacher t, HttpServletRequest req) {
		aDAO.getOneSchool(s, req);
		aDAO.getOneSchoolTeacher(t, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHomePet.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//원장-관리자 유치원 신청 테이블에 등록
	@RequestMapping(value = "apply.school", method = RequestMethod.GET)
	public String applySchool(ApplySchool s, HttpServletRequest req) {
		aDAO.applySchool(s, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//선생님-원장 신청 테이블에 등록
	@RequestMapping(value = "apply.teacher", method = RequestMethod.GET)
	public String applyTeacher(ApplyTeacher t, HttpServletRequest req) {
		aDAO.applyTeacher(t, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//견주-원장 강아지 신청 테이블에 등록
	@RequestMapping(value = "apply.pet", method = RequestMethod.POST)
	public String applyPet(ApplyPet p, HttpServletRequest req) {
		aDAO.applyPet(p, req);
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//수락하기 페이지로 이동: 추후에 권한마다 보이는 목록 나눠 줘야 함
	@RequestMapping(value = "accept.go", method = RequestMethod.GET)
	public String accept(HttpServletRequest req) {
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//관리자: 유치원 수락
	@RequestMapping(value = "apply.pass.s", method = RequestMethod.GET)
	public String applyPassSchool(ApplySchool s, HttpServletRequest req) {
		//해당 유치원 승인 0->1 작업
		aDAO.schoolPass(s, req);
		
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//관리자: 유치원 거절(재신청하게 컬럼 삭제 진행)
	@RequestMapping(value = "apply.fail.s", method = RequestMethod.GET)
	public String applyFailSchool(ApplySchool s, HttpServletRequest req) {
		//해당 유치원 거절 -> 다시 신청하게 테이블에서 삭제
		aDAO.schoolFail(s, req);
		
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//원장: 선생님 등록 수락
	@RequestMapping(value = "apply.pass.t", method = RequestMethod.GET)
	public String applyPassTeacher(ApplyTeacher t, HttpServletRequest req) {
		//승인 0->1 작업
		aDAO.teacherPass(t, req);
			
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//원장: 선생님 등록 거절(재신청하게 컬럼 삭제 진행)
	@RequestMapping(value = "apply.fail.t", method = RequestMethod.GET)
	public String applyFailTeacher(ApplyTeacher t, HttpServletRequest req) {
		//거절 -> 다시 신청하게 테이블에서 삭제
		aDAO.teacherFail(t, req);
			
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}

	//원장: 강아지(견주) 등록 수락
	@RequestMapping(value = "apply.pass.p", method = RequestMethod.GET)
	public String applyPassPet(ApplyPet p, HttpServletRequest req) {
		//승인 0->1 작업
		aDAO.petPass(p, req);
			
		aDAO.getAllSchoolApply(req); //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(req); //		선생님전체목록조회
		aDAO.getAllPetApply(req); //			강아지전체목록조회
		req.setAttribute("loginPage", "main/loginPage.jsp");
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//원장: 강아지(견주) 등록 거절(재신청하게 컬럼 삭제 진행)
	@RequestMapping(value = "apply.fail.p", method = RequestMethod.GET)
	public String applyFailPet(ApplyPet p, HttpServletRequest req) {
		//거절 -> 다시 신청하게 테이블에서 삭제
		aDAO.petFail(p, req);
			
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

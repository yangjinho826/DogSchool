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
import org.springframework.web.multipart.MultipartFile;

import com.dog.HC.manage.ManageDAO;
import com.dog.HC.member.Member;
import com.dog.HC.member.MemberDAO;

@Controller
public class ApplyController {
	@Autowired
	private ApplyDAO aDAO;
	
	@Autowired
	private ManageDAO mDAO;
	
	@Autowired
	private MemberDAO mDAOO;
	
	//신청하는 폼으로 이동
	@RequestMapping(value = "apply.go", method = RequestMethod.GET)
	public String apply(Member m, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		mDAO.getAllSchool(req);
		mDAO.getAllTeacher(req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHome.jsp");			
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//유치원 선택 후 견주 등록하는 폼으로 이동
	@RequestMapping(value = "apply.go.pet", method = RequestMethod.GET)
	public String applyGoPet(ApplySchool s, ApplyTeacher t, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		aDAO.getOneSchool(s, req);
		aDAO.getOneSchoolTeacher(t, req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyHomePet.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//원장->관리자 유치원 신청
	@RequestMapping(value = "apply.school", method = RequestMethod.GET)
	public String applySchool(Member m, ApplySchool s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		aDAO.applySchool(s, req);
		
		//주체: 원장
		mDAO.getMyTeacher(m, req); //승인한 목록 조회
		mDAO.getMyPet(m, req);
		
		mDAO.getAllSchool(req);
		
		aDAO.getMySchoolApply(m, req); //신청내역  유치원전체목록조회
		aDAO.getMyTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getMyPetApply(m, req); //			강아지전체목록조회
	
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyWaiting.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//선생님->원장 신청
	@RequestMapping(value = "apply.teacher", method = RequestMethod.GET)
	public String applyTeacher(Member m, ApplyTeacher t, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		aDAO.applyTeacher(t, req);
		
		aDAO.getMySchoolApply(m, req); //       유치원전체목록조회
		aDAO.getMyTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getMyPetApply(m, req); //			강아지전체목록조회
	
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyWaiting.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//견주->원장 강아지 신청 테이블에 등록
	@RequestMapping(value = "apply.pet", method = RequestMethod.POST)
	public String applyPet(Member m, ApplyPet p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		aDAO.applyPet(p, req);
		
		aDAO.getMySchoolApply(m, req); //       유치원전체목록조회
		aDAO.getMyTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getMyPetApply(m, req); //			강아지전체목록조회
	
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyWaiting.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//(각자)신청수락 내역 페이지로 이동
	@RequestMapping(value = "apply.waiting", method = RequestMethod.GET)
	public String waiting(Member m, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		
		//수락: 원장
		mDAO.getMyTeacher(m, req); //승인한 목록 조회
		mDAO.getMyPet(m, req);
		
		mDAO.getAllSchool(req);
		
		aDAO.getMySchoolApply(m, req); //		유치원전체목록조회
		aDAO.getMyTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getMyPetApply(m, req); //			강아지전체목록조회
			
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/applyWaiting.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//수락하기 페이지로 이동: 추후에 권한마다 보이는 목록 나눠 줘야 함
	@RequestMapping(value = "accept.go", method = RequestMethod.GET)
	public String accept(Member m, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); 	  //	강아지전체목록조회
		
		mDAO.getAllSchool(req);			 	//	승인된유치원전체

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//관리자: 유치원 수락
	@RequestMapping(value = "apply.pass.s", method = RequestMethod.GET)
	public String applyPassSchool(Member m, ApplySchool s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		//해당 유치원 승인 0->1 작업
		aDAO.schoolPass(s, req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); //			강아지전체목록조회
		
		mDAO.getAllSchool(req);
	
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//관리자: 유치원 거절(재신청하게 컬럼 삭제 진행)
	@RequestMapping(value = "apply.fail.s", method = RequestMethod.GET)
	public String applyFailSchool(Member m, ApplySchool s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		//해당 유치원 거절 -> 다시 신청하게 테이블에서 삭제
		aDAO.schoolFail(s, req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); //			강아지전체목록조회
		
		mDAO.getAllSchool(req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//원장: 선생님 등록 수락
	@RequestMapping(value = "apply.pass.t", method = RequestMethod.GET)
	public String applyPassTeacher(Member m, ApplyTeacher t, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		//승인 0->1 작업
		aDAO.teacherPass(t, req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); //			강아지전체목록조회
		
		mDAO.getAllSchool(req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//원장: 선생님 등록 거절(재신청하게 컬럼 삭제 진행)
	@RequestMapping(value = "apply.fail.t", method = RequestMethod.GET)
	public String applyFailTeacher(Member m, ApplyTeacher t, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		//거절 -> 다시 신청하게 테이블에서 삭제
		aDAO.teacherFail(t, req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); //			강아지전체목록조회
		
		mDAO.getAllSchool(req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}

	//원장: 강아지(견주) 등록 수락
	@RequestMapping(value = "apply.pass.p", method = RequestMethod.GET)
	public String applyPassPet(Member m, ApplyPet p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		//승인 0->1 작업
		aDAO.petPass(p, req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); //			강아지전체목록조회
		
		mDAO.getAllSchool(req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	//원장: 강아지(견주) 등록 거절(재신청하게 컬럼 삭제 진행)
	@RequestMapping(value = "apply.fail.p", method = RequestMethod.GET)
	public String applyFailPet(Member m, ApplyPet p, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		//거절 -> 다시 신청하게 테이블에서 삭제
		aDAO.petFail(p, req);
		aDAO.getAllSchoolApply(req);  //신청대기중인유치원전체목록조회
		aDAO.getAllTeacherApply(m, req); //		선생님전체목록조회
		aDAO.getAllPetApply(m, req); //			강아지전체목록조회
		
		mDAO.getAllSchool(req);

		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "apply/acceptHome.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
}

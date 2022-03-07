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
		
		mDAO.getTotal();
		mDAO.pageView(s, req);
		mDAO.page(s, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "manage/manageSchool.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	//(관리자) 시스템 이용 중인 유치원 삭제
	@RequestMapping(value = "manage.delete", method = RequestMethod.GET)
	public String deleteSchool(ApplySchool s, HttpServletRequest req) {
		if(mDAOO.loginCheck(req)) {
			mDAO.deleteSchool(s, req); //Dapply_table에서 유치원 삭제
			mDAO.deleteSchoolT(s, req); //해당 유치원의 선생님 모두 삭제 - Tapply_table
			mDAO.deleteSchoolU(s, req); //						Uapply_table
			
			//유치원 후기 삭제 review_table
			//유치원 가격표 삭제 priceTag_table
			//유치원 공지 삭제 notice_table
			//선생님 후기 삭제 postscript_table
			//유치원 스케쥴 삭제 schedule_table
			//알림장 삭제 mypet_table
			//갤러리 삭제 gallery_table
			mDAO.deleteAllOneSchool(s, req);
		}

		//다시 조회
		mDAO.getTotal();
		mDAO.pageView(s, req);
		mDAO.page(s, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "manage/manageSchool.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}
	
	
	//////////////////////////////////////////////////////////////////
	//검색
	@RequestMapping(value = "search.go", method = RequestMethod.GET)
	public String manageSearch(ApplySchool s, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		
		mDAO.getSearchTotal(s, req);
		mDAO.searchSchool(s, req);
		mDAO.page(s, req);
		
		req.setAttribute("MenuBar", "main/menu.jsp");
		req.setAttribute("contentPage", "manage/manageSchool.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		return "index";
	}

}

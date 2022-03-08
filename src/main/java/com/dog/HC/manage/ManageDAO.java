package com.dog.HC.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplyMapper;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.member.Member;
import com.dog.HC.schoolmain.notice;
import com.dog.HC.schoolmain.noticemapper;

@Service
public class ManageDAO {
	@Autowired
	private SqlSession ss;
	
	//////////////////////////////////////////////////////
	//페이징
	int TotalCount = 0;
	
	public void getTotal() {	 
		 TotalCount = ss.getMapper(ManageMapper.class).getManageTotalCount();              
	}
	public void pageView(ApplySchool s, HttpServletRequest req) {
		String strPg = req.getParameter("pg");
		
		int rowSize = 3; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	    
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	    
	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
	    
	    s.setdA_no(from);
	    s.setdA_agree(to); 

		List<ApplySchool> lists = ss.getMapper(ManageMapper.class).getAllSchoolPage(s);
		req.setAttribute("lists", lists);
	}
	public void page(ApplySchool s, HttpServletRequest req) {
		String strPg = req.getParameter("pg");
	   	 
	    int rowSize = 3; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = TotalCount; //총 게시물 수
	    int allPage = (int) Math.ceil(total/(double)rowSize); //페이지수
	    int block = 5; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>

	    int fromPage = ((pg-1)/block*block)+1;  //보여줄 페이지의 시작
	    int toPage = ((pg-1)/block*block)+block; //보여줄 페이지의 끝
	    if(toPage> allPage){ // 예) 20>17
	        toPage = allPage;
	    }

	    req.setAttribute("pg", pg);
	    req.setAttribute("block", block);
	    req.setAttribute("fromPage", fromPage);
	    req.setAttribute("toPage", toPage);
	    req.setAttribute("allPage", allPage);
	    req.setAttribute("rowSize", rowSize);
	    req.setAttribute("TotalCount", total);
	}
	
	
	//승인된 유치원 조회
	public void getAllSchool(HttpServletRequest req) {
		try {
			req.setAttribute("passSchools", ss.getMapper(ManageMapper.class).getAllSchool());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//승인된 선생님 조회
	public void getAllTeacher(HttpServletRequest req) {
		try {
			req.setAttribute("passTeachers", ss.getMapper(ManageMapper.class).getAllTeacher());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//승인된 유저(강아지) 조회
	public void getAllPet(HttpServletRequest req) {
		try {
			req.setAttribute("passPets", ss.getMapper(ManageMapper.class).getAllPet());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/////////////////////////////////////////////////////////////////
	//관리자가 등록된 유치원 삭제(사이트 이용 불가)
	public void deleteSchool(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		if (ss.getMapper(ManageMapper.class).deleteSchool(s) == 1) {
			System.out.println("유치원 삭제 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("유치원 삭제 실패");
		}
	}
	public void deleteSchoolT(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		if (ss.getMapper(ManageMapper.class).deleteSchoolT(s) >= 1) {
			System.out.println("해당 유치원에 등록된 선생님 삭제 성공"); //테이블에서 해당 컬럼 삭제
		} else if(ss.getMapper(ManageMapper.class).deleteSchoolT(s) == 0) {
			System.out.println("해당 유체원에 삭제할 선생님 없음"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("해당 유치원에 등록된 선생님 삭제 실패");
		}
	}
	public void deleteSchoolU(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		if (ss.getMapper(ManageMapper.class).deleteSchoolU(s) >= 1) {
			System.out.println("해당 유치원에 등록된 강아지(견주) 삭제 성공"); //테이블에서 해당 컬럼 삭제
		} else if(ss.getMapper(ManageMapper.class).deleteSchoolU(s) == 0) {
			System.out.println("해당 유체원에 삭제할 강아지(견주) 없음"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("해당 유치원에 등록된 강아지(견주) 삭제 실패");
		}
	}
	//후기, 공지, 가격표, 테이블 등등 해당 유치원 관련 데이터 모두 삭제
	public void deleteAllOneSchool(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		if(ss.getMapper(ManageMapper.class).deleteReview(s) >= 1) {
			System.out.println("유치원 후기 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deleteReview(s) == 0) {
			System.out.println("삭제할 유치원 후기 없음");
		} else {
			System.out.println("유치원 후기 삭제 실패");
		}
		
		if(ss.getMapper(ManageMapper.class).deletePricetag(s) >= 1) {
			System.out.println("유치원 가격표 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deletePricetag(s) == 0) {
			System.out.println("삭제할 유치원 가격표 없음");
		} else {
			System.out.println("유치원 가격표 삭제 실패");
		}
		
		if(ss.getMapper(ManageMapper.class).deleteNotice(s) >= 1) {
			System.out.println("유치원 공지 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deleteNotice(s) == 0) {
			System.out.println("삭제할 유치원 공지 없음");
		} else {
			System.out.println("유치원 공지 삭제 실패");
		}
		
		if(ss.getMapper(ManageMapper.class).deletePostscript(s) >= 1) {
			System.out.println("선생님 후기 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deletePostscript(s) == 0) {
			System.out.println("삭제할 선생님 후기 없음");
		} else {
			System.out.println("선생님 후기 삭제 실패");
		}
		
		if(ss.getMapper(ManageMapper.class).deleteSchedule(s) >= 1) {
			System.out.println("유치원 스케쥴 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deleteSchedule(s) == 0) {
			System.out.println("삭제할 유치원 스케쥴 없음");
		} else {
			System.out.println("유치원 스케쥴 삭제 실패");
		}
		
		if(ss.getMapper(ManageMapper.class).deleteMypetDiary(s) >= 1) {
			System.out.println("알림장 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deleteMypetDiary(s) == 0) {
			System.out.println("삭제할 알림장 없음");
		} else {
			System.out.println("알림장 삭제 실패");
		}
		
		if(ss.getMapper(ManageMapper.class).deleteMypetGallery(s) >= 1) {
			System.out.println("갤러리 삭제 성공");
		} else if(ss.getMapper(ManageMapper.class).deleteMypetGallery(s) == 0) {
			System.out.println("삭제할 갤러리 없음");
		} else {
			System.out.println("갤러리 삭제 실패");
		}
	}

	
	////////////////////////////////////////////////////////////////
	//타입 반환
	public void getType(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try{
			req.setAttribute("getType", ss.getMapper(ManageMapper.class).getType(m));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	////////////////////////////////////////////////////////////
	//승인한(된) 목록 전체 조회
	public void getMyTeacher(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myPassTeachers", ss.getMapper(ManageMapper.class).getMyTeacher(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getMyPet(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myPassPets", ss.getMapper(ManageMapper.class).getMyPet(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	///////////////////////////////////////////////////////////////////
	//검색+페이징
	public void getSearchTotal(ApplySchool s, HttpServletRequest req) {	 
		String w = req.getParameter("searchWord");
		s.setdA_schoolname(w);
		TotalCount = ss.getMapper(ManageMapper.class).getManageSearchTotalCount(s);              
	}
	public void searchSchool(ApplySchool s, HttpServletRequest req) {
		String w = req.getParameter("searchWord");
		s.setdA_schoolname(w);
		
		String strPg = req.getParameter("pg");
		
		int rowSize = 3; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	    
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	    
	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
	    
	    s.setdA_no(from);
	    s.setdA_agree(to); 

	    req.setAttribute("lists", ss.getMapper(ManageMapper.class).search(s));
	}
}

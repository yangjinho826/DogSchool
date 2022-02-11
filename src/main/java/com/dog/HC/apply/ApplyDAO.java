package com.dog.HC.apply;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.manage.ManageMapper;
import com.dog.HC.member.Member;
import com.dog.HC.schoolmain.priceTag;
import com.dog.HC.schoolmain.priceTagmapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class ApplyDAO {
	
	@Autowired
	private SqlSession ss;

	//원장-관리자 유치원 신청
	public void applySchool(ApplySchool s, HttpServletRequest req) {
		try {
			String Da_id = req.getParameter("Da_id");
			String Da_name = req.getParameter("Da_name");
			String Da_schoolname = req.getParameter("Da_schoolname");
			String Da_addr1 = req.getParameter("Da_addr1");
			String Da_addr2 = req.getParameter("Da_addr2");
			String Da_addr3 = req.getParameter("Da_addr3");
			String Da_addr = Da_addr1 + " " + Da_addr2 + " " + Da_addr3 + "(우편번호)";
			String Da_phonenumber = req.getParameter("Da_phonenumber");
			
			s.setDa_id(Da_id); 
			s.setDa_name(Da_name);
			s.setDa_schoolname(Da_schoolname);
			s.setDa_addr(Da_addr);
			s.setDa_phonenumber(Da_phonenumber);
			s.setDa_agree(0);

			if (ss.getMapper(ApplyMapper.class).schoolapply(s) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
		}
	}

	//선생님-원장 등록 신청
	public void applyTeacher(ApplyTeacher t, HttpServletRequest req) {
		try {
			int Ta_da_no = Integer.parseInt(req.getParameter("Ta_da_no"));
			String Ta_id = req.getParameter("Ta_id");
			String Ta_name = req.getParameter("Ta_name");
			String Ta_phonenumber = req.getParameter("Ta_phonenumber");
			String Ta_gender = req.getParameter("Ta_gender");
			String Ta_text = req.getParameter("Ta_text");
			
			t.setTa_da_no(Ta_da_no);
			t.setTa_id(Ta_id);
			t.setTa_name(Ta_name);
			t.setTa_phonenumber(Ta_phonenumber);
			t.setTa_gender(Ta_gender);
			t.setTa_text(Ta_text);
			t.setTa_agree(0);

			if (ss.getMapper(ApplyMapper.class).teacherapply(t) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
		}
	}

	//견주-원장 강아지 신청
	public void applyPet(ApplyPet p, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
			return;
		}

		try {
			int Ua_da_no = Integer.parseInt(mr.getParameter("Ua_da_no"));
			String Ua_id = mr.getParameter("Ua_id");
			String Ua_name = mr.getParameter("Ua_name");
			String Ua_gender = mr.getParameter("Ua_gender");
			String Ua_daterange = mr.getParameter("Ua_daterange");
			int Ua_age = Integer.parseInt(mr.getParameter("Ua_age"));
			String Ua_img = mr.getFilesystemName("Ua_img");
			Ua_img = URLEncoder.encode(Ua_img, "utf-8");
			Ua_img = Ua_img.replace("+", " ");
			String Ua_tname = mr.getParameter("Ua_tname");
			
			p.setUa_da_no(Ua_da_no);
			p.setUa_id(Ua_id);
			p.setUa_name(Ua_name);
			p.setUa_gender(Ua_gender);
			p.setUa_daterange(Ua_daterange);
			p.setUa_age(Ua_age);
			p.setUa_img(Ua_img);
			p.setUa_tname(Ua_tname);

			if (ss.getMapper(ApplyMapper.class).petapply(p) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("Ua_img");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "가입실패");
		}
	}

	//신청 중인 원장-관리자 유치원 전체 조회
	public void getAllSchoolApply(HttpServletRequest req) {
		try {
			req.setAttribute("schools", ss.getMapper(ApplyMapper.class).getSchoolApply());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//신청 중인 선생님-원장 선생님 전체 조회
	public void getAllTeacherApply(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		try {
			req.setAttribute("teachers", ss.getMapper(ApplyMapper.class).getTeacherApply(mm));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	//신청 중인 견주-원장 강아지 전체 조회
	public void getAllPetApply(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		try {
			req.setAttribute("pets", ss.getMapper(ApplyMapper.class).getPetApply(mm));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//유치원 승인(관리자)
	public void schoolPass(ApplySchool s, HttpServletRequest req) {
		//Da_no 유치원 구분 코드 받아서
		//Da_agree 1로 update

		s.setDa_no(Integer.parseInt(req.getParameter("Da_no")));
		
		if (ss.getMapper(ApplyMapper.class).schoolPass(s) == 1) {
			System.out.println("유치원 수락 성공");
		} else {
			System.out.println("유치원 수락 실패");
		}
	}
	//유치원 거절(관리자)
	public void schoolFail(ApplySchool s, HttpServletRequest req) {
		s.setDa_no(Integer.parseInt(req.getParameter("Da_no")));
		if (ss.getMapper(ApplyMapper.class).schoolFail(s) == 1) {
			System.out.println("유치원 거절 성공");
		} else {
			System.out.println("유치원 거절 실패");
		}
	}

	//선생님 승인(원장)
	public void teacherPass(ApplyTeacher t, HttpServletRequest req) {
		t.setTa_no(Integer.parseInt(req.getParameter("Ta_no")));
		if (ss.getMapper(ApplyMapper.class).teacherPass(t) == 1) {
			System.out.println("선생님 수락 성공"); //Ta_agree: 0->1
		} else {
			System.out.println("선생님 수락 실패");
		}
	}
	//선생님 거절(원장)
	public void teacherFail(ApplyTeacher t, HttpServletRequest req) {
		t.setTa_no(Integer.parseInt(req.getParameter("Ta_no")));
		if (ss.getMapper(ApplyMapper.class).teacherFail(t) == 1) {
			System.out.println("선생님 거절 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("선생님 거절 실패");
		}
	}

	//강아지 승인(원장)
	public void petPass(ApplyPet p, HttpServletRequest req) {
		p.setUa_no(Integer.parseInt(req.getParameter("Ua_no")));
		if (ss.getMapper(ApplyMapper.class).petPass(p) == 1) {
			System.out.println("강아지 수락 성공"); //Ta_agree: 0->1
		} else {
			System.out.println("강아지 수락 실패");
		}
	}
	//강아지 거절(원장)
	public void petFail(ApplyPet p, HttpServletRequest req) {
		p.setUa_no(Integer.parseInt(req.getParameter("Ua_no")));
		if (ss.getMapper(ApplyMapper.class).petFail(p) == 1) {
			System.out.println("강아지 거절 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("강아지 거절 실패");
		}
	}
	
	//한 유치원에 존재하는 모든 선생님 조회
	public void getOneSchoolTeacher(ApplyTeacher t, HttpServletRequest req) {
		t.setTa_da_no(Integer.parseInt(req.getParameter("Da_no")));
		req.setAttribute("getOneSchoolTeacher", ss.getMapper(ApplyMapper.class).getOneSchoolTeacher(t));
	}
	//한 유치원 정보 조회
	public void getOneSchool(ApplySchool s, HttpServletRequest req) {
		s.setDa_no(Integer.parseInt(req.getParameter("Da_no")));
		try {
			req.setAttribute("getOneSchool", ss.getMapper(ApplyMapper.class).getOneSchool(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//로그인 후 내가 신청해서 수락 대기 중인 목록 보기
	public void getMySchoolApply(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myWaitingSchools", ss.getMapper(ApplyMapper.class).getMySchoolApply(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void getMyTeacherApply(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myWaitingTeachers", ss.getMapper(ApplyMapper.class).getMyTeacherApply(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getMyPetApply(Member m, HttpServletRequest req) {
		Member mm = (Member) req.getSession().getAttribute("loginMember");
		m.setId(mm.getId());
		try {
			req.setAttribute("myWaitingPets", ss.getMapper(ApplyMapper.class).getMyPetApply(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 학원 세션 받아오기
	public void getSchoolSession(ApplySchool d, HttpServletRequest req) {
		
		int Da_no = Integer.parseInt(req.getParameter("ps.da_no"));
		d.setDa_no(Da_no);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool getSchoolSession = mm.getSchoolSession(d);
	
		req.getSession().setAttribute("school", getSchoolSession.getDa_no());
		req.getSession().setAttribute("schoolname", getSchoolSession.getDa_name());
		req.getSession().setAttribute("getSchoolSession", getSchoolSession);
		req.getSession().setMaxInactiveInterval(60 * 100);
		
	}

	public void TeachCheck(ApplyTeacher a, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if(m == null) {
			return;
		}
		
		int Ta_da_no = as.getDa_no();
		String Ta_id = m.getId();
		
		a.setTa_da_no(Ta_da_no);
		a.setTa_id(Ta_id);
		
		System.out.println(Ta_da_no);
		System.out.println(Ta_id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplyTeacher TCheck = mm.TeachCheck(a);
		
		req.setAttribute("TCheck",TCheck);

	}

	public void DirectorCheck(ApplySchool aps, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if(m == null) {
			return;
		}
		
		int Ta_da_no = as.getDa_no();
		String Ta_id = m.getId();
		
		aps.setDa_no(Ta_da_no);
		aps.setDa_id(Ta_id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool DCheck = mm.DirectorCheck(aps);
		
		req.setAttribute("DCheck",DCheck);
	}

	public void UserCheck(ApplyPet ap, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if(m == null) {
			return;
		}
		
		int Ta_da_no = as.getDa_no();
		String Ta_id = m.getId();
		
		ap.setUa_da_no(Ta_da_no);
		ap.setUa_id(Ta_id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplyPet UCheck = mm.UserCheck(ap);
		
		req.setAttribute("UCheck",UCheck);

	}

	




}

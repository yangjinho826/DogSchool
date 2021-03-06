package com.dog.HC.apply;

import java.applet.Applet;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dog.HC.Yuchiwon.YuchiwonMapper;
import com.dog.HC.Yuchiwon.puppy;
import com.dog.HC.member.Member;

@Service
public class ApplyDAO {
	
	@Autowired
	private SqlSession ss;
	
    int TotalCount = 0;
    
    public void getTotal() {     
         ApplyMapper mm = ss.getMapper(ApplyMapper.class);
         TotalCount = mm.getlistTotalCount();              
    }
     
    public void pageView(ApplySchool s, HttpServletRequest req) {
        String strPg = req.getParameter("pg");
        
        int rowSize = 15; //한페이지에 보여줄 글의 수
        int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
        
        if(strPg != null){ //list.jsp?pg=2
            pg = Integer.parseInt(strPg); //.저장
        }
        
        int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
        int to=(pg * rowSize); //(1*10) = 10 //to
        
        s.setdA_no(from);
        s.setdA_agree(to);
        
        
        ApplyMapper mm = ss.getMapper(ApplyMapper.class);
        List<ApplySchool> passSchools = mm.getAlllist(s);
        req.setAttribute("passSchools", passSchools);
 
    }
    
    public void page(ApplySchool s, HttpServletRequest req) {
        String strPg = req.getParameter("pg");
            
        int rowSize = 15; //한페이지에 보여줄 글의 수
        int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
       
        if(strPg != null){ //list.jsp?pg=2
            pg = Integer.parseInt(strPg); //.저장
        }
       
        int total = TotalCount; //총 게시물 수
        int allPage = (int) Math.ceil(total/(double)rowSize); //페이지수
        int block = 10; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>

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
    
	
	int TeacherDa_no = 0;

	//원장-관리자 유치원 신청
	public void applySchool(ApplySchool s, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if(token.equals(successToken)){ return; }
			
			String Da_addr1 = req.getParameter("dA_addr1");
			String Da_addr2 = req.getParameter("dA_addr2");
			String Da_addr3 = req.getParameter("dA_addr3");
			String Da_addr = Da_addr1 + " " + Da_addr2 + " " + Da_addr3 + "(우편번호)";
			
			s.setdA_id(req.getParameter("dA_id")); 
			s.setdA_name(req.getParameter("dA_name"));
			s.setdA_schoolname(req.getParameter("dA_schoolname"));
			s.setdA_addr(Da_addr);
			s.setdA_phonenumber(req.getParameter("dA_phonenumber"));
			s.setdA_agree(0);

			if (ss.getMapper(ApplyMapper.class).schoolapply(s) == 1) {
				req.setAttribute("result", "가입성공");
				req.getSession().setAttribute("successToken", token);
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
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if(token.equals(successToken)){ return; }
			
			t.settA_da_no(Integer.parseInt(req.getParameter("tA_da_no")));
			t.settA_id(req.getParameter("tA_id"));
			t.settA_name(req.getParameter("tA_name"));
			t.settA_phonenumber(req.getParameter("tA_phonenumber"));
			t.settA_gender(req.getParameter("tA_gender"));
			t.settA_text(req.getParameter("tA_text"));
			t.settA_agree(0);
			
			if (ss.getMapper(ApplyMapper.class).teacherapply(t) == 1) {
				req.setAttribute("result", "가입성공");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "가입실패");					
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
		}
	}
	//견주-원장 강아지 신청
	public void applyPet(@RequestParam("uA_img") MultipartFile mf, ApplyPet p, HttpServletRequest req) {

		String root = "";
		String changeFile = "";
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");

			if (token.equals(successToken)) {
				return;
			}

			// path 가져오기
			String path = req.getSession().getServletContext().getRealPath("resources");
			root = path + "\\" + "img";
			
			File fileCheck = new File(root);
			if (!fileCheck.exists()) {
				fileCheck.mkdirs();
			}
			String originFile = mf.getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			changeFile = UUID.randomUUID().toString() + ext;

			Map<String, String> map = new HashMap<String, String>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);

			p.setuA_da_no(Integer.parseInt(req.getParameter("uA_da_no")));
			p.setuA_id(req.getParameter("uA_id"));
			p.setuA_name(req.getParameter("uA_name"));
			p.setuA_gender(req.getParameter("uA_gender"));
			p.setuA_age(Integer.parseInt(req.getParameter("uA_age")));
			p.setuA_img(changeFile);
			p.setuA_ta_no(Integer.parseInt(req.getParameter("uA_ta_no")));
			p.setuA_agree(0);
			
			// 파일업로드
			File uploadFile = new File(root + "\\" + changeFile);
			mf.transferTo(uploadFile);

			if (ss.getMapper(ApplyMapper.class).petapply(p) == 1) {
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(root + "\\" + changeFile).delete();
		}
	}
	//견주-원장 강아지 신청
	public void applyPetUpdate(@RequestParam("imggg") MultipartFile mf, ApplyPet p, HttpServletRequest req) {

		String root = "";
		String changeFile = "";
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");

			if (token.equals(successToken)) {
				return;
			}

			// path 가져오기
			String path = req.getSession().getServletContext().getRealPath("resources");
			root = path + "\\" + "img";
			System.out.println(root);
			File fileCheck = new File(root);
			if (!fileCheck.exists()) {
				fileCheck.mkdirs();
			}
			String originFile = mf.getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			changeFile = UUID.randomUUID().toString() + ext;

			Map<String, String> map = new HashMap<String, String>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);

			p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
			p.setuA_da_no(Integer.parseInt(req.getParameter("uA_da_no")));
			p.setuA_id(req.getParameter("uA_id"));
			p.setuA_name(req.getParameter("uA_name"));
			p.setuA_gender(req.getParameter("uA_gender"));
			p.setuA_age(Integer.parseInt(req.getParameter("uA_age")));
			p.setuA_img(changeFile);
			p.setuA_ta_no(Integer.parseInt(req.getParameter("uA_ta_no")));
			p.setuA_agree(0);
				
			// 파일업로드
			File uploadFile = new File(root + "\\" + changeFile);
			mf.transferTo(uploadFile);

			if (ss.getMapper(ApplyMapper.class).petapplyupdate(p) == 1) {
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(root + "\\" + changeFile).delete();
		}
	}

	
	//////////////////////////////////////////////////////////////
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

	
	/////////////////////////////////////////////////////////////////
	//유치원 승인(관리자)
	public void schoolPass(ApplySchool s, HttpServletRequest req) {
		//Da_no 유치원 구분 코드 받아서
		//Da_agree 1로 update

		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		
		if (ss.getMapper(ApplyMapper.class).schoolPass(s) == 1) {
			System.out.println("유치원 수락 성공");
		} else {
			System.out.println("유치원 수락 실패");
		}
	}
	//유치원 거절(관리자)
	public void schoolFail(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		if (ss.getMapper(ApplyMapper.class).schoolFail(s) == 1) {
			System.out.println("유치원 거절 성공");
		} else {
			System.out.println("유치원 거절 실패");
		}
	}
	//선생님 승인(원장)
	public void teacherPass(ApplyTeacher t, HttpServletRequest req) {
		t.settA_no(Integer.parseInt(req.getParameter("tA_no")));
		if (ss.getMapper(ApplyMapper.class).teacherPass(t) == 1) {
			System.out.println("선생님 수락 성공"); //Ta_agree: 0->1
		} else {
			System.out.println("선생님 수락 실패");
		}
	}
	//선생님 거절(원장)
	public void teacherFail(ApplyTeacher t, HttpServletRequest req) {
		t.settA_no(Integer.parseInt(req.getParameter("tA_no")));
		if (ss.getMapper(ApplyMapper.class).teacherFail(t) == 1) {
			System.out.println("선생님 거절 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("선생님 거절 실패");
		}
	}
	//강아지 승인(원장)
	public void petPass(ApplyPet p, HttpServletRequest req) {
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		if (ss.getMapper(ApplyMapper.class).petPass(p) == 1) {
			System.out.println("강아지 수락 성공"); //Ta_agree: 0->1
		} else {
			System.out.println("강아지 수락 실패");
		}
	}
	//강아지 거절(원장)
	public void petFail(ApplyPet p, HttpServletRequest req) {
		
		
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		
		if (ss.getMapper(ApplyMapper.class).petFail(p) == 1) {
			System.out.println("강아지 거절 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("강아지 거절 실패");
		}
	}
	
	
	//////////////////////////////////////////////////////////
	//한 유치원에 존재하는 모든 선생님 조회
	public void getOneSchoolTeacher(ApplyTeacher t, HttpServletRequest req) {
		t.settA_da_no(Integer.parseInt(req.getParameter("dA_no")));
		req.setAttribute("getOneSchoolTeacher", ss.getMapper(ApplyMapper.class).getOneSchoolTeacher(t));
	}
	//한 유치원 정보 조회
	public void getOneSchool(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		try {
			req.setAttribute("getOneSchool", ss.getMapper(ApplyMapper.class).getOneSchool(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	////////////////////////////////////////////////////
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
		
		
		if(TeacherDa_no > 0 ) {
			d.setdA_no(TeacherDa_no);	
			TeacherDa_no = 0;
		}else{
			int Da_no = Integer.parseInt(req.getParameter("ps.dA_no"));
			d.setdA_no(Da_no);
		}
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool getSchoolSession = mm.getSchoolSession(d);
		
		req.getSession().setAttribute("school", getSchoolSession.getdA_no());
		req.getSession().setAttribute("schoolname", getSchoolSession.getdA_schoolname());
		req.getSession().setAttribute("getSchoolSession", getSchoolSession);
		req.getSession().setMaxInactiveInterval(60 * 100);
			
	}
	
	// 관리하는 강아지가 없을경우 바로 유치원을 가기위해 TeacherDa_no을 구한다.
	public void getCheckregTeacher(ApplySchool d, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String Ta_id = m.getId();
		
		d.setdA_id(Ta_id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool ap = mm.getTeacherDano(d);
		
		TeacherDa_no = ap.getdA_no();
	}
	
	// 유저로그인 -> 리스트에서 세션 받아오기
	public int getulistSession(HttpServletRequest req, ApplySchool as) {
		String id = req.getParameter("id");
		
		as.setdA_id(id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool ap = mm.getulistSession(as);
		
		if(ap == null) {
			return 0;
		}

		req.getSession().setAttribute("school", ap.getdA_no());
		req.getSession().setAttribute("schoolname", ap.getdA_schoolname());
		req.getSession().setAttribute("getSchoolSession", ap);
		req.getSession().setMaxInactiveInterval(60 * 100);
		return ap.getdA_no();
	}
	// 선생님로그인 -> 리스트에서 세션 받아오기
	public int gettlistSession(HttpServletRequest req, ApplySchool as, ApplyTeacher at) {
		String id = req.getParameter("id");
		as.setdA_id(id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool ap = mm.gettlistSession(as);

		if(ap == null) {
			return 2;
		}
		
		req.getSession().setAttribute("school", ap.getdA_no());
		req.getSession().setAttribute("schoolname", ap.getdA_schoolname());
		req.getSession().setAttribute("getSchoolSession", ap);
		req.getSession().setMaxInactiveInterval(60 * 100);
		
		if(!ap.getdA_id().equals("")) {
			Member member = (Member) req.getSession().getAttribute("loginMember");
		    String tA_id = member.getId();
		    
		    at.settA_id(tA_id);
		    		
			YuchiwonMapper ym = ss.getMapper(YuchiwonMapper.class);
			int puppcount = ym.getpuppcount(at);

			if(puppcount >= 1) {
				return 1;
			}else{
				return 0;
			}
		}
		return 0;
	}
	
	// 원장로그인 -> 리스트에서 세션 받아오기
	public int getDlistSession(HttpServletRequest req, ApplySchool as, ApplyTeacher at) {
		String id = req.getParameter("id");
		
		as.setdA_id(id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool ap = mm.getDlistSession(as);
		
		if(ap == null) {
			return 0;
		}

		req.getSession().setAttribute("school", ap.getdA_no());
		req.getSession().setAttribute("schoolname", ap.getdA_schoolname());
		req.getSession().setAttribute("getSchoolSession", ap);
		req.getSession().setMaxInactiveInterval(60 * 100);
		return ap.getdA_no();
	}

	
	//기간 만료 확인
	// 유저로그인
	public int getUDaterangeCheck(HttpServletRequest req, ApplySchool as) {
		String id = req.getParameter("id");
		as.setdA_id(id);
			
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		
		ApplySchool app = mm.getulistSession(as);

		req.getSession().setAttribute("school", app.getdA_no());
		req.getSession().setAttribute("schoolname", app.getdA_schoolname());
		req.getSession().setAttribute("getSchoolSession", app);
		req.getSession().setMaxInactiveInterval(60 * 100);
		
		int totalPet = mm.getAllPetCount(as); 	//해당 유저의 모든 강아지 카운트
		int ap = mm.getUDaterangeCheck(as);		//해당 유저의 기간 만료 강아지 카운트

		if(totalPet != 0 && totalPet != ap) {
			return 4;
		} else { //모든 강아지 == 기간 만료 강아지
			return 5;
		}
	}
	// 선생님로그인
	public int getTDaterangeCheck(HttpServletRequest req, ApplySchool as, ApplyTeacher at) {
		String id = req.getParameter("id");
		as.setdA_id(id);
			
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);

		ApplySchool app = mm.gettlistSession(as);

		req.getSession().setAttribute("school", app.getdA_no());
		req.getSession().setAttribute("schoolname", app.getdA_schoolname());
		req.getSession().setAttribute("getSchoolSession", app);
		req.getSession().setMaxInactiveInterval(60 * 100);
		
		int totalPet = mm.getAllTeacherPetCount(as);//해당 유저의 모든 강아지 카운트
		int ap = mm.getTDaterangeCheck(as);			//해당 유저의 기간 만료 강아지 카운트

		if(totalPet != 0 && totalPet != ap) {
			return 4;
		} else { //모든 강아지 == 기간 만료 강아지
			return 5;
		}
	}

	
	public void TeachCheck(ApplyTeacher a, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if(m == null) {
			return;
		}
		
		int Ta_da_no = as.getdA_no();
		String Ta_id = m.getId();

		a.settA_da_no(Ta_da_no);
		a.settA_id(Ta_id);

		
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
		
		int Ta_da_no = as.getdA_no();
		String Ta_id = m.getId();
		
		aps.setdA_no(Ta_da_no);
		aps.setdA_id(Ta_id);
		
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
		
		int Ta_da_no = as.getdA_no();
		String Ta_id = m.getId();
		
		ap.setuA_da_no(Ta_da_no);
		ap.setuA_id(Ta_id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplyPet UCheck = mm.UserCheck(ap);
		
		req.setAttribute("UCheck",UCheck);

	}

	
	/////////////////////////////////////////////////////////////
	//신청 취소
	public void applyCancelSchool(ApplySchool s, HttpServletRequest req) {
		s.setdA_no(Integer.parseInt(req.getParameter("dA_no")));
		if (ss.getMapper(ApplyMapper.class).schoolFail(s) == 1) {
			System.out.println("유치원 신청 취소 성공");
		} else {
			System.out.println("유치원 신청 취소 실패");
		}
	}
	public void applyCancelTeacher(ApplyTeacher t, HttpServletRequest req) {
		t.settA_no(Integer.parseInt(req.getParameter("tA_no")));
		if (ss.getMapper(ApplyMapper.class).teacherFail(t) == 1) {
			System.out.println("선생님 신청 취소 성공");
		} else {
			System.out.println("선생님 신청 취소 실패");
		}
	}
	public void applyCancelPet(ApplyPet p, HttpServletRequest req) {
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		if (ss.getMapper(ApplyMapper.class).petFail(p) == 1) {
			System.out.println("강아지 신청 취소 성공");
		} else {
			System.out.println("강아지 신청 취소 실패");
		}
	}
	
	
	///////////////////////////////////////////////////////
	//원장: 선생님, 견주 삭제
	public void applyDeleteTeacher(ApplyTeacher t, HttpServletRequest req) {
		t.settA_no(Integer.parseInt(req.getParameter("tA_no")));
		if (ss.getMapper(ApplyMapper.class).deleteTeacher(t) == 1) {
			System.out.println("선생님 삭제 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("선생님 삭제 실패");
		}
	}
	public void applyDeleteTeacherP(ApplyTeacher t, HttpServletRequest req) {
		t.settA_no(Integer.parseInt(req.getParameter("tA_no")));
		if(ss.getMapper(ApplyMapper.class).deleteTeacherInPet(t) >= 1) {
			System.out.println("해당 강아지 선생님 빈칸 처리 완료");
		} else {
			System.out.println("해당 강아지 선생님 빈칸 처리 실패(또는 맡은 강아지 없음)");
		}
	}
	public void applyDeletePet(ApplyPet p, HttpServletRequest req) {
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		if (ss.getMapper(ApplyMapper.class).deletePet(p) == 1) {
			System.out.println("강아지 삭제 성공"); //테이블에서 해당 컬럼 삭제
		} else {
			System.out.println("강아지 삭제 실패");
		}
	}
	
	//견주가 선생님 재신청 시에 넘겨질 나머지 견주&강아지 정보
	public void myPetInfo(ApplyPet p, HttpServletRequest req) {
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		try {
			req.setAttribute("myPetOne", ss.getMapper(ApplyMapper.class).getPetOne(p));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//견주가 신청 내역에서 정보 수정 시 갖고 올 정보 조회
	public void myApplyPetInfo(ApplyPet p, HttpServletRequest req) {
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		try {
			req.setAttribute("myApplyPet", ss.getMapper(ApplyMapper.class).getPetOne(p));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//재신청
	public void applyPetOnlyTeacher(ApplyPet p, HttpServletRequest req) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		p.setuA_ta_no(Integer.parseInt(req.getParameter("uA_ta_no")));

		if (ss.getMapper(ApplyMapper.class).reapplyPetOnlyTeacher(p) == 1) {
			System.out.println("선생님 재신청 성공");
			req.getSession().setAttribute("successToken", token);
		} else {
			System.out.println("선생님 재신청 실패");
		}
	}
	public void applyPetOnlyDaterange(ApplyPet p, HttpServletRequest req) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		p.setuA_no(Integer.parseInt(req.getParameter("uA_no")));
		p.setuA_daterange(req.getParameter("uA_daterange"));

		if (ss.getMapper(ApplyMapper.class).reapplyPetOnlyDaterange(p) == 1) {
			System.out.println("기간 연장 재신청 성공");
			req.getSession().setAttribute("successToken", token);
		} else {
			System.out.println("기간 연장 재신청 실패");
		}
	}
	
	//선생님 중복 체크
	public int checkTeacher(Member m, HttpServletRequest req) {
		return ss.getMapper(ApplyMapper.class).checkTeacher(m);
	}
	
	// 날짜 지난 거 지우기
	public void UpdateDaterange(HttpServletRequest req, ApplyPet ap) throws ParseException {
				
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		List<ApplyPet> AR = mm.getAllPetApply();
	
	
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		String now = sdf.format(d);
		Date now1 = sdf.parse(now);
		
		
		for (ApplyPet a : AR) {
			String Udaterange = a.getuA_daterange();
			if(!Udaterange.equals("기간 만료")) {
				String Udaterange2 =  Udaterange.substring(13,23);
				Udaterange2 = Udaterange2.replace("/", "-");
				Date Udaterange3 = sdf.parse(Udaterange2); //마지막날짜 - 현재날짜
				
				
				long result = Udaterange3.getTime() - now1.getTime();
				
				if(result < 0) {
					int no = a.getuA_no();
					Date endDay = sdf.parse(Udaterange2);
					Calendar cal = Calendar.getInstance();	
					cal.setTime(endDay);
					cal.add(Calendar.DATE, 6); // 종료일 기준 +7
					String endDay2 = sdf.format(cal.getTime());
					
					ap.setuA_no(no);
					ap.setuA_daterange(endDay2);
					
					if(mm.UpdateendDay(ap) >= 1){
						System.out.println("업데이트성공");
					}else {
						System.out.println("업데이트실패");
					}
				}

				if(result < 0) {
					int no = a.getuA_no();
					ap.setuA_no(no);
					if(mm.UpdateDaterange(ap) >= 1){
						System.out.println("업데이트성공");
					}else {
						System.out.println("업데이트실패");
					}
				}
		
			}
		}
}
	public void endDayCheck(HttpServletRequest req, ApplyPet ap) throws ParseException {
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		List<ApplyPet> AR = mm.getAllPetApply();
	
	
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		String now = sdf.format(d);
		Date now1 = sdf.parse(now);
			
		for (ApplyPet a : AR) {
			String endDay = a.getuA_endDay() == null ? "0" : a.getuA_endDay();

			if(endDay.equals("0")){
				return;
			}
			
			Date endDay1 = sdf.parse(endDay);
			long result = endDay1.getTime() - now1.getTime();
			
			if(result > 0) {
				return;
			}
			
			
			if(result < 0){
				int no = a.getuA_no();
				ap.setuA_no(no);
					
				if(mm.deleteendDay(ap) == 1){
					System.out.println("삭제성공");
				}else {
					System.out.println("삭제실패");
				}
			}
			
		}
	
	}
	
	
	public void getSchoolname(HttpServletRequest req, ApplySchool as) {
		
		int uA_da_no = Integer.parseInt(req.getParameter("uA_da_no"));
		
		as.setdA_no(uA_da_no);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		ApplySchool School = mm.getSchoolname(as);
		req.setAttribute("Schoolname", School.getdA_schoolname());
	}


	
	
}

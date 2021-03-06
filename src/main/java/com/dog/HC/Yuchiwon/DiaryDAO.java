package com.dog.HC.Yuchiwon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.manage.ManageMapper;

@Service
public class DiaryDAO {
	
	int TotalCount = 0;
	String strPg = null;
	
	
	@Autowired
	private SqlSession ss;


	public void getTotal(diary d, HttpServletRequest req) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");

		
		int mp_tnum = p.getuA_ta_no();
		String mp_uid = p.getuA_id();
		String mp_uname = p.getuA_name();
		
		d.setMp_tnum(mp_tnum);
		d.setMp_uid(mp_uid);
		d.setMp_uname(mp_uname);
		
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		TotalCount = dm.diarytotalcount(d);

			
	}

	public void pageView(diary d, HttpServletRequest req) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");

		
		int rowSize = 5; //한페이지에 보여줄 글의 수
		int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1

		if(req.getParameter("pg") != null) {
			strPg = req.getParameter("pg");
		}
		
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }


		int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
		int to=(pg * rowSize); //(1*10) = 10 //to

		int mp_tnum = p.getuA_ta_no();
		String mp_uid = p.getuA_id();
		String mp_uname = p.getuA_name();

		d.setMp_tnum(mp_tnum);
		d.setMp_uid(mp_uid);
		d.setMp_uname(mp_uname);
		d.setTo(to);
		d.setFrom(from);

		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		List<diary> diaries = dm.getAllDiary(d);
		req.setAttribute("diaries", diaries);

	}

	public void page(diary d, HttpServletRequest req) {
		 
	
		if(req.getParameter("pg") != null) {
			strPg = req.getParameter("pg");
		}
		
	    int rowSize = 5; //한페이지에 보여줄 글의 수
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
	
	


	//다이어리 작성하기
	public void writeDiary(HttpServletRequest req, diary d) {

		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		puppy p = (puppy) req.getSession().getAttribute("puppies");
		
		
		int mp_da_no = p.getuA_da_no();
		int mp_tnum = p.getuA_ta_no();
		ApplyTeacher teacher = ss.getMapper(ManageMapper.class).getTeacherId(p.getuA_ta_no());
		String mp_uid = p.getuA_id();
		String mp_uname = p.getuA_name();

		d.setMp_da_no(mp_da_no);
		d.setMp_tnum(mp_tnum);
		d.setMp_tid(teacher.gettA_id());
		d.setMp_uid(mp_uid);
		d.setMp_uname(mp_uname);

		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		if (dm.writeDiary(d) == 1) {
			System.out.println("등록성공");
			req.getSession().setAttribute("successToken", token);
			
		} else {
			System.out.println("등록실패");
		}
	}

	
	public void getDiary(HttpServletRequest req, diary d, diaryReply dr) {
		
//		int mp_no = Integer.parseInt(req.getParameter("mp_no"));
//		d.setMp_no(mp_no);
		
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		d = dm.getDiary(d);
		
		List<diaryReply> replys = dm.getReply(d);
		if(replys != null) {
			d.setMp_replys(replys);
		}

		req.setAttribute("d", d);
	}

	
	public void writeReply(HttpServletRequest req, diary d, diaryReply dr) {
	
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		if (dm.writeReply(dr) == 1) {
			System.out.println("댓글성공");
			req.getSession().setAttribute("successToken", token);
		} else {
			System.out.println("댓글실패");
		}
	}

	public void deleteReply(HttpServletRequest req, diary d, diaryReply dr) {

		try {
			if (ss.getMapper(DiaryMapper.class).deleteReply(dr) == 1) {
				req.setAttribute("result", "댓글삭제성공");
			} else {
				req.setAttribute("result", "댓글삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글삭제실패");
		}

	}

	public void updateDiary(HttpServletRequest req, diary d) {

		DiaryMapper mm = ss.getMapper(DiaryMapper.class);

		if (mm.updateDiary(d) == 1) {
			req.setAttribute("result", "알림장수정성공");
		}else {
			req.setAttribute("result", "알림장수정실패");
		}
		
	}

	public void deleteDiary(HttpServletRequest req, diary d) {

		try {
			if (ss.getMapper(DiaryMapper.class).deleteDiary(d) == 1) {
				req.setAttribute("result", "알림장삭제성공");
			} else {
				req.setAttribute("result", "알림장삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "알림장삭제실패");
		}

	}

	public void getFiveDiary(HttpServletRequest req, diary d) {
	    DiaryMapper mm = ss.getMapper(DiaryMapper.class);
	    List<diary> diaries = mm.getFiveDiary(d);
		req.setAttribute("diaries", diaries);
		}


	public void strPg_initialization() {
		TotalCount = 0;
		strPg = null;
	}

		
}

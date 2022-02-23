package com.dog.HC.Yuchiwon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Service;

import com.dog.HC.manage.ManageMapper;
import com.dog.HC.member.Member;

@Service
public class DiaryDAO {

	int TotalCount = 0;
	
	@Autowired
	private SqlSession ss;

	public void getAllDiary(HttpServletRequest req, diary d) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");
	
		System.out.println(p.getuA_no());
		String mp_tnum = ss.getMapper(ManageMapper.class).getTeacherId(p.getuA_ta_no());
		String mp_uid = p.getuA_id();
		String mp_uname = p.getuA_name();

		d.setMp_tid(mp_tnum);
		d.setMp_uid(mp_uid);
		d.setMp_uname(mp_uname);

		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		List<diary> diaries = dm.getAllDiary(d);

		for (diary diary : diaries) {
			diary.setMp_replys(ss.getMapper(DiaryMapper.class).getReply(diary));
		}

		req.setAttribute("diaries", diaries);
	}

	public void writeDiary(HttpServletRequest req, diary d) {

		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		puppy p = (puppy) req.getSession().getAttribute("puppies");

		String mp_tid = ss.getMapper(ManageMapper.class).getTeacherId(p.getuA_ta_no());
		String mp_uid = p.getuA_id();
		String mp_uname = p.getuA_name();

		d.setMp_tid(mp_tid);
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

	public void getDiary(HttpServletRequest req, diary d) {
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		diary dr = dm.getDiary(d);

		req.setAttribute("d", dr);
	}

	public void writeReply(HttpServletRequest req, diaryReply dr) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String r_owner = m.getName();
		dr.setR_owner(r_owner);

		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		if (dm.writeReply(dr) == 1) {
			System.out.println("댓글성공");
		} else {
			System.out.println("댓글실패");
		}
	}

	public void deleteReply(HttpServletRequest req, diaryReply dr) {

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

		try {
			if (ss.getMapper(DiaryMapper.class).updateDiary(d) == 1) {
				req.setAttribute("result", "알림장수정성공");
			} else {
				req.setAttribute("result", "알림장수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public void getFiveDiary(HttpServletRequest req) {
	    DiaryMapper mm = ss.getMapper(DiaryMapper.class);
	    puppy p = (puppy) req.getSession().getAttribute("puppies");
	    diary d = new diary();
	    d.setMp_uname(p.getuA_name());
	    d.setMp_tnum(p.getuA_ta_no());
	    d.setMp_uid(p.getuA_id());
	    
	    List<diary> diaries = mm.getFiveDiary(d);
		req.setAttribute("diaries", diaries);
		}

	public void getTotal(HttpServletRequest req, diary d) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");
	    d.setMp_uname(p.getuA_name());
	    d.setMp_tnum(p.getuA_ta_no());
	    d.setMp_uid(p.getuA_id());
	    
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		TotalCount = dm.getDiaryTotalCount(d);
	}

	public void pageView(HttpServletRequest req, diary d) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");
		d.setMp_tnum(p.getuA_ta_no());
	    d.setMp_uname(p.getuA_name());
	    d.setMp_uid(p.getuA_id());
		
		String strPg = req.getParameter("pg");
		
		int rowSize = 3;
		int pg = 1;
		
		if(strPg != null) {
			pg = Integer.parseInt(strPg);
		}
		
		int from = (pg * rowSize) - (rowSize-1);
	    int to=(pg * rowSize);
	    
	    d.setFrom(from);
	    d.setTo(to);
	    
	    DiaryMapper dm = ss.getMapper(DiaryMapper.class);
	    List<diary> diaries = dm.getAllDiary(d);
	    req.setAttribute("diaries", diaries);
		
	}

	public void page(HttpServletRequest req, diary d) {
		String strPg = req.getParameter("pg");
	   	 
	    int rowSize = 3;
	    int pg = 1;
	   
	    if(strPg != null){
	        pg = Integer.parseInt(strPg);
	    }
	   
	    int total = TotalCount;
	    int allPage = (int) Math.ceil(total/(double)rowSize);
	    int block = 5;

	    int fromPage = ((pg-1)/block*block)+1;
	    int toPage = ((pg-1)/block*block)+block;
	    if(toPage> allPage){
	        toPage = allPage;
	    }

	    req.setAttribute("pg", pg);
	    req.setAttribute("block", block);
	    req.setAttribute("fromPage", fromPage);
	    req.setAttribute("toPage", toPage);
	    req.setAttribute("allPage", allPage);
	    req.setAttribute("rowSize", rowSize);
	    req.setAttribute("TotalCount", total);
	    System.out.println("---------------------------");
		System.out.println(fromPage);
		System.out.println(toPage);
		System.out.println(allPage);
		System.out.println(rowSize);
		System.out.println(total);
	}
		
	}

package com.dog.HC.Yuchiwon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.member.Member;

@Service
public class DiaryDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllDiary(HttpServletRequest req, diary d) {
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		List<diary> diaries = dm.getAllDiary();

		for (diary diary : diaries) {
			diary.setMp_replys(ss.getMapper(DiaryMapper.class).getReply(diary));
		}
		
		
		req.setAttribute("diaries", diaries);
	}

	public void writeDiary(HttpServletRequest req, diary d) {
		String mp_tid = req.getParameter("mp_tid");
		String mp_uid = req.getParameter("mp_uid");
		String mp_uname = req.getParameter("mp_uname");
		
		d.setMp_tid(mp_tid);
		d.setMp_uid(mp_uid);
		d.setMp_uname(mp_uname);
		
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		if(dm.writeDiary(d) == 1) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
	}

	public void getDiary(HttpServletRequest req, diary d) {
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		diary dr= dm.getDiary(d);
			
		req.setAttribute("d", dr);
	}
	
	public void writeReply(HttpServletRequest req, diaryReply dr) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String r_owner = m.getName();
		dr.setR_owner(r_owner);
		
		DiaryMapper dm = ss.getMapper(DiaryMapper.class);
		if(dm.writeReply(dr) == 1) {
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
}

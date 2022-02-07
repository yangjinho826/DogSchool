package com.dog.HC.schoolmain;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class scheduleDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAllschedule(schedule s, HttpServletRequest req) {
	
		schedulemapper mm = ss.getMapper(schedulemapper.class);
		List<schedule> schedules = mm.getAllschedule();
		req.setAttribute("sh", schedules);

	}
	
	public void getschedulewirte(schedule s, HttpServletRequest req){
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		int s_da_no = 1;
		s.setS_da_no(s_da_no);
		
		String s_day = req.getParameter("s_day");
        String s_day2 =  s_day.substring(5,7);
        s_day2 +="월";
        s.setS_month(s_day2);
        
		
		schedulemapper mm = ss.getMapper(schedulemapper.class);
		
		if(mm.scheduleWrite(s) == 1){
			System.out.println("등록성공");
			req.getSession().setAttribute("successToken", token);
		}else {
			System.out.println("등록실패");
		}
		
	}

	public void getschedule(schedule s, HttpServletRequest req) {
	    int s_no = Integer.parseInt(req.getParameter("s_no"));
	    s.setS_no(s_no);
		 
	    schedulemapper mm = ss.getMapper(schedulemapper.class);
	    schedule sc = mm.getschedule(s);
		req.setAttribute("sc", sc);
		
	}

	public void scheduleUpdate(schedule s, HttpServletRequest req) {
		
		String s_day = req.getParameter("s_day");
        String s_day2 =  s_day.substring(5,7);
        s_day2 +="월";
        s.setS_month(s_day2);
		
		schedulemapper mm = ss.getMapper(schedulemapper.class);
		if(mm.scheduleUpdate(s) == 1){
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
		
		
	}

	public void scheduleDelete(schedule s, HttpServletRequest req) {
		
		schedulemapper mm = ss.getMapper(schedulemapper.class);
		if(mm.scheduleDelete(s) == 1){
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
	}

}

	

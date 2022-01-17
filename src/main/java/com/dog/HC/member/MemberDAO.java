package com.dog.HC.member;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	public void login(HttpServletRequest req, Member m) {
		
		Member dbMember = ss.getMapper(MemberMapper.class).getUserID(m);

		if(dbMember != null) {
			if(m.getPw().equals(dbMember.getPw())) {
				req.getSession().setAttribute("loginMember", dbMember);
				req.getSession().setMaxInactiveInterval(60 * 5);
			} else {
				req.setAttribute("result", "로그인 실패(비밀번호 오류)");
			}
		}else {
			req.setAttribute("result", "로그인 실패(가입안된 ID)");
		}
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if(m != null) {
			req.setAttribute("loginPage", "main/loginSuccess.jsp");
			return true;
		}else {
			req.setAttribute("loginPage", "main/loginPage.jsp");
			return false;
		}
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	public void usingup(HttpServletRequest req, Member m) {

		int n = Integer.parseInt(req.getParameter("type"));
		
		System.out.println(n);
		
		if(n == 1) {
			try {
				String id = req.getParameter("id");
				String pw = req.getParameter("pw");
				String name = req.getParameter("name");
				String phonenumber = req.getParameter("phonenumber");
				String gender = req.getParameter("gender");

				m.setId(id);
				m.setPw(pw);
				m.setName(name);
				m.setPhonenumber(phonenumber);
				m.setGender(gender);

				if (ss.getMapper(MemberMapper.class).usignup(m) == 1) {
					req.setAttribute("result", "가입완료");
				} else {
					req.setAttribute("result", "가입실패");
				}

			} catch (Exception e) {
				req.setAttribute("result", "가입실패");
			}
		}
		
		else if(n == 2) {
			try {
				String id = req.getParameter("id");
				String pw = req.getParameter("pw");
				String name = req.getParameter("name");
				String phonenumber = req.getParameter("phonenumber");
				String gender = req.getParameter("gender");

				m.setId(id);
				m.setPw(pw);
				m.setName(name);
				m.setPhonenumber(phonenumber);
				m.setGender(gender);

				if (ss.getMapper(MemberMapper.class).tsignup(m) == 1) {
					req.setAttribute("result", "가입완료");
				} else {
					req.setAttribute("result", "가입실패");
				}

			} catch (Exception e) {
				req.setAttribute("result", "가입실패");
			}
			
		}else if(n == 3) {
			try {
				String id = req.getParameter("id");
				String pw = req.getParameter("pw");
				String name = req.getParameter("name");
				String phonenumber = req.getParameter("phonenumber");
				String gender = req.getParameter("gender");

				m.setId(id);
				m.setPw(pw);
				m.setName(name);
				m.setPhonenumber(phonenumber);
				m.setGender(gender);

				if (ss.getMapper(MemberMapper.class).dsignup(m) == 1) {
					req.setAttribute("result", "가입완료");
				} else {
					req.setAttribute("result", "가입실패");
				}

			} catch (Exception e) {
				req.setAttribute("result", "가입실패");
			}
			
		}
			
		}

}

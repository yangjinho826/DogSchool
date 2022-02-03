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
		Member dbMember = ss.getMapper(MemberMapper.class).getUserID1(m);	
		//int nn = dbMember.getType(); // ==1 or ==2 or ==3
		
		//int n = Integer.parseInt(req.getParameter("type"));

		if(dbMember != null) {
			if(m.getPw().equals(dbMember.getPw())) {
				req.getSession().setAttribute("loginMember", dbMember);
				req.getSession().setMaxInactiveInterval(60 * 5);
			} else {
				req.setAttribute("result", "로그인 실패(비밀번호 오류)");
				System.out.println("로그인 실패(비밀번호 오류)");
			}
		}else {
			System.out.println("로그인 실패(가입안된 ID)");
			req.setAttribute("result", "로그인 실패(가입안된 ID)");
		}
		
	}
	
	
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		
		if(m != null) {
			req.setAttribute("loginPage", "main/loginSuccess.jsp");
			req.setAttribute("memberTypee", m.getTypee());
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
				String phonenumber = req.getParameter("phonefirst")
			 			 + req.getParameter("phonesecond")
			 			 + req.getParameter("phonethird");
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
				String phonenumber = req.getParameter("phonefirst")
			 			 + req.getParameter("phonesecond")
			 			 + req.getParameter("phonethird");
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
				String phonenumber = req.getParameter("phonefirst")
			 			 + req.getParameter("phonesecond")
			 			 + req.getParameter("phonethird");
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



	public void update(HttpServletRequest req, Member m) {
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

		if (ss.getMapper(MemberMapper.class).update(m) == 1) {
			req.setAttribute("result", "수정성공");
			req.getSession().setAttribute("loginMember", m);
		} else {
			req.setAttribute("result", "수정실패");
		}
	} catch (Exception e) {
		e.printStackTrace();
		req.setAttribute("result", "수정실패");
	}
		
	}


	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("result", "탈퇴성공");

				logout(req);
				loginCheck(req);
			} else {
				req.setAttribute("result", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}
		
	}



	public void findid(HttpServletRequest req, Member m) {
		Member dbMember = ss.getMapper(MemberMapper.class).findid(m);

		//사용자가 입력한 값
		m.getName();
		m.getPhonenumber();
		
		System.out.println(m.getName());
		System.out.println(m.getPhonenumber());
		System.out.println(dbMember.getName());
		System.out.println(dbMember.getPhonenumber());
		// 이 값으로 select
		if(dbMember != null) {
			if(m.getName().equals(dbMember.getName())) {
				req.setAttribute("result", dbMember.getId());
			}else {
			System.out.println("아이디 찾기 실패(가입안된 ID)");
			req.setAttribute("result", "아이디 찾기 실패(가입안된 ID)");
		}

		}
}



	public void findpw(HttpServletRequest req, Member m) {
		Member dbMember = ss.getMapper(MemberMapper.class).findpw(m);

		// 사용자가 입력한 값
		m.getId();
		m.getName();
		m.getPhonenumber();

		System.out.println(m.getId());
		System.out.println(m.getName());
		System.out.println(m.getPhonenumber());
		System.out.println(dbMember.getId());
		System.out.println(dbMember.getName());
		System.out.println(dbMember.getPhonenumber());
		// 이 값으로 select
		if (dbMember != null) {
			if (m.getName().equals(dbMember.getName())) {
				req.setAttribute("result", dbMember.getPw());
			} else {
				System.out.println("비밀번호 찾기 실패");
				req.setAttribute("result", "비밀번호 찾기 실패");
			}

		}

	}
}

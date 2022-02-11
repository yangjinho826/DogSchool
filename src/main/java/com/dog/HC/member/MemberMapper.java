package com.dog.HC.member;


public interface MemberMapper {
	
	public Member getUserID1(Member m);

	public int usignup(Member m);

	public int tsignup(Member m);

	public int dsignup(Member m);

	public int update(Member m);

	public int bye(Member m);

	public Member findid(Member m);

	public Member findpw(Member m);
	
	public int getMemberNum(Member m);


	



}

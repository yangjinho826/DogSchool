package com.dog.HC.member;


public interface MemberMapper {

	public int usignup(Member m);

	public int tsignup(Member m);

	public int dsignup(Member m);

	public Member getUserID1(Member m);

	public Member getUserID2(Member m);

	public Member getUserID3(Member m);

	public int update(Member m);


}

package com.dog.HC.manage;

import java.util.List;

import com.dog.HC.apply.ApplyPet;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.member.Member;

public interface ManageMapper {
	public List<ApplySchool> getAllSchool();
	public int deleteSchool(ApplySchool s);
	public List<ApplyTeacher> getAllTeacher();
	public List<Member> getType(Member m);
	public List<ApplyPet> getAllPet();
	public List<ApplyTeacher> getMyTeacher(Member m);
	public List<ApplyPet> getMyPet(Member m);
}

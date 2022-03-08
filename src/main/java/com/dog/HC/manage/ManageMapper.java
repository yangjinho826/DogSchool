package com.dog.HC.manage;

import java.util.List;

import com.dog.HC.apply.ApplyPet;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.member.Member;

public interface ManageMapper {
	public List<ApplySchool> getAllSchool();
	public int deleteSchool(ApplySchool s);
	public int deleteSchoolT(ApplySchool s);
	public int deleteSchoolU(ApplySchool s);
	public List<ApplyTeacher> getAllTeacher();
	public List<Member> getType(Member m);
	public List<ApplyPet> getAllPet();
	public List<ApplyTeacher> getMyTeacher(Member m);
	public List<ApplyPet> getMyPet(Member m);
	public int getManageTotalCount();
	public List<ApplySchool> getAllSchoolPage(ApplySchool s);
	public List<ApplySchool> search(ApplySchool s);
	public int getManageSearchTotalCount(ApplySchool s);
	public ApplyTeacher getTeacherId(int getuA_da_no);
	
	public int deleteReview(ApplySchool s);
	public int deleteNotice(ApplySchool s);
	public int deletePostscript(ApplySchool s);
	public int deleteSchedule(ApplySchool s);
	public int deleteMypetDiary(ApplySchool s);
	public int deletePricetag(ApplySchool s);
	public int deleteMypetGallery(ApplySchool s);
}

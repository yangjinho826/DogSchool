package com.dog.HC.apply;

import java.util.List;

import com.dog.HC.member.Member;

public interface ApplyMapper {
	int schoolapply(ApplySchool s);
	int teacherapply(ApplyTeacher t);
	int petapply(ApplyPet p);
	public List<ApplySchool> getSchoolApply();
	public List<ApplyTeacher> getTeacherApply(Member mm);
	public List<ApplyPet> getPetApply(Member mm);
	int schoolPass(ApplySchool s);
	int schoolFail(ApplySchool s);
	int teacherPass(ApplyTeacher t);
	int teacherFail(ApplyTeacher t);
	int petPass(ApplyPet p);
	int petFail(ApplyPet p);
	public List<ApplyTeacher> getOneSchoolTeacher(ApplyTeacher t);
	public List<ApplySchool> getOneSchool(ApplySchool s);
	public List<ApplySchool> getMySchoolApply(Member m);
	public List<ApplyTeacher> getMyTeacherApply(Member m);
	public List<ApplyPet> getMyPetApply(Member m);
	int deleteTeacher(ApplyTeacher t);
	int deleteTeacherInPet(ApplyTeacher t);
	int deletePet(ApplyPet p);
	public List<ApplyPet> getPetOne(ApplyPet p);
	int reapplyPetOnlyTeacher(ApplyPet p);
	int checkTeacherExit(ApplyTeacher t);
	int checkTeacher(Member m);
}

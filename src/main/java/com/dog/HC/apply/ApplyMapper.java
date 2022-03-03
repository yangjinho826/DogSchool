package com.dog.HC.apply;

import java.util.List;
import java.util.Map;

import com.dog.HC.Yuchiwon.puppy;
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

	public ApplySchool getSchoolSession(ApplySchool d);
	public ApplyTeacher TeachCheck(ApplyTeacher a);
	public ApplySchool DirectorCheck(ApplySchool aps);
	public ApplyPet UserCheck(ApplyPet ap);

	public int deleteTeacher(ApplyTeacher t);
	public int deleteTeacherInPet(ApplyTeacher t);
	public int deletePet(ApplyPet p);
	public List<ApplyPet> getPetOne(ApplyPet p);
	public int reapplyPetOnlyTeacher(ApplyPet p);
	public int reapplyPetOnlyDaterange(ApplyPet p);
	
	public int checkTeacherExit(ApplyTeacher t);
	public int checkTeacher(Member m);
	
	public ApplySchool getulistSession(ApplySchool as);
	public ApplySchool gettlistSession(ApplySchool as);
	public int UpdateDaterange(ApplyPet ap);
	public List<ApplyPet> getAllPetApply();
	public ApplySchool getTeacherDano(ApplySchool d);
	public ApplySchool getSchoolname(ApplySchool as);
	
	public int UpdateendDay(ApplyPet ap);
	public int deleteendDay(ApplyPet ap);
	int getlistTotalCount();
	List<ApplySchool> getAlllist(ApplySchool s);
	
	public int getUDaterangeCheck(ApplySchool as);
	public int getTDaterangeCheck(ApplySchool as);
	public int getAllTeacherPetCount(ApplySchool as);
	public int getAllPetCount(ApplySchool as);
	public int petapplyupdate(ApplyPet p);
	public int getCheckPetEmpty(ApplySchool as);
	public int getExistPetCount(ApplySchool as);
	

}

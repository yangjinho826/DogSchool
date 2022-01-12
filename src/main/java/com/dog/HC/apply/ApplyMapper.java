package com.dog.HC.apply;

import java.util.List;

public interface ApplyMapper {
	int schoolapply(ApplySchool s);
	int teacherapply(ApplyTeacher t);
	int petapply(ApplyPet p);
	public List<ApplySchool> getSchoolApply();
	public List<ApplyTeacher> getTeacherApply();
	public List<ApplyPet> getPetApply();
}

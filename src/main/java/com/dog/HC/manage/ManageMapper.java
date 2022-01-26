package com.dog.HC.manage;

import java.util.List;

import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;

public interface ManageMapper {
	public List<ApplySchool> getAllSchool();
	public int deleteSchool(ApplySchool s);
	public List<ApplyTeacher> getAllTeacher();
}

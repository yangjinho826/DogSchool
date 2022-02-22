package com.dog.HC.Yuchiwon;

import java.util.List;
import java.util.Map;

import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;

public interface YuchiwonMapper {

	public List<puppy> getAllPuppy(Map<String, String> mm);

	public puppy getPuppy(puppy puppy);

	public int getpuppcount(ApplyTeacher at);

}

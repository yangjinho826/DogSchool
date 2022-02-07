package com.dog.HC.Yuchiwon;

import java.util.List;
import java.util.Map;

public interface YuchiwonMapper {

	public List<puppy> getAllPuppy(Map<String, String> mm);

	public puppy getPuppy(puppy puppy);

}

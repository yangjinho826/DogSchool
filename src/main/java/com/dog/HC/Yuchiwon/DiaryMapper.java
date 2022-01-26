package com.dog.HC.Yuchiwon;

import java.util.List;

public interface DiaryMapper {

	public List<diary> getAllDiary();

	public int writeDiary(diary d);

	public diary getDiary(diary d);
	
}

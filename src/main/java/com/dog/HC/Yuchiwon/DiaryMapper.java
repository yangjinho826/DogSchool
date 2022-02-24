package com.dog.HC.Yuchiwon;

import java.util.List;

public interface DiaryMapper {

	public List<diary> getAllDiary(diary d);

	public int writeDiary(diary d);

	public diary getDiary(diary d);

	public int writeReply(diaryReply dr);

	public List<diaryReply> getReply(diary diary);

	public int deleteReply(diaryReply dr);

	public int updateDiary(diary d);

	public int deleteDiary(diary d);

	List<diary> getFiveDiary();

	public int diarytotalcount(diary d);

}

package com.dog.HC.schoolmain;

import java.util.List;

public interface schedulemapper {

	List<schedule> getAllschedule(schedule s);

	int scheduleWrite(schedule s);

	schedule getschedule(schedule s);

	int scheduleUpdate(schedule s);

	int scheduleDelete(schedule s);

	List<schedule> getmonschedule(schedule s);

}

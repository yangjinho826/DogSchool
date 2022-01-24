package com.dog.HC.schoolmain;

import java.util.List;

public interface noticemapper {

	public List<notice> getAllnotice();
	
	public int noticeWrite(notice n);
	
	public notice getnotice(notice n);
	
	public int noticeDelete(notice n);
	
	public int noticeUpdate(notice n);
	
}

package com.dog.HC.schoolmain;

import java.util.ArrayList;
import java.util.List;

public interface noticemapper {

	public List<notice> getAllnotice(notice n);
	
	public int noticeWrite(notice n);
	
	public notice getnotice(notice n);
	
	public int noticeTDelete(notice n);
	
	public int noticeDDelete(notice n);
	
	public int noticeUpdate(notice n);

	public int getNoticeTotalCount(notice n);

	public List<notice> getfivenotice(notice n);

	
	
}

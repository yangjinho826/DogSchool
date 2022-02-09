package com.dog.HC.review;

import java.util.List;

public interface ReviewMapper {

	public List<review> getAllreview();

	public int reviewWrite(review r);

	public review getreview(review r);

	public int reviewDelete(review r);

	public int reviewUpdate(review r);

}

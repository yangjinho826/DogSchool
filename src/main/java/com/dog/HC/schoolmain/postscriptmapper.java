package com.dog.HC.schoolmain;

import java.util.List;

public interface postscriptmapper {

	List<postscript> getAllpostscript(postscript p);

	int postscriptWrite(postscript p);

	postscript getpostscript(postscript p);

	int postscriptDelete(postscript p);

	int postscriptUpdate(postscript p);

	int getpostscripTotalCount();

	List<postscript> getfivepostscript(postscript p);

}

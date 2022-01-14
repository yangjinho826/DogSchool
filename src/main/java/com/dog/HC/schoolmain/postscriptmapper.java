package com.dog.HC.schoolmain;

import java.util.List;

public interface postscriptmapper {

	List<postscript> getAllpostscript();

	int postscriptWrite(postscript p);

	postscript getpostscript(postscript p);

	int postscriptDelete(postscript p);

	int postscriptUpdate(postscript p);

}

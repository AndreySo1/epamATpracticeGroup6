package org.example.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface CommentTestdata {

	String NAME = "commentTestdata";
	String JNDI_NAME = "java:app/untitled1-bootstrap/CommentTestdataBean";

	void insert();

}

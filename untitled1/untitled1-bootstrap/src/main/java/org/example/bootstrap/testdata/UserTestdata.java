package org.example.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface UserTestdata {

	String NAME = "userTestdata";
	String JNDI_NAME = "java:app/untitled1-bootstrap/UserTestdataBean";

	void insert();
}

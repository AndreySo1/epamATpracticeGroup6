package org.example.weblogic;

import javax.ejb.Local;

import org.example.model.BlogEntry;

@Local
public interface BlogEntryService {

	String NAME = "blogEntryService";
	String JNDI_NAME = "java:app/untitled1-ejb/BlogEntryServiceBean";

	BlogEntry getInstance();

	boolean newInstance();

	boolean persistOrUpdate();

	boolean delete();

	Long getId();

	void setId(Long id);

	void remove();
}

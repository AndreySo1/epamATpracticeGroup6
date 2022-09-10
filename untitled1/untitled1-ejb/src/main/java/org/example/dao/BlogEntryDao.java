package org.example.dao;

import java.util.List;

import javax.ejb.Local;

import org.example.model.BlogEntry;

@Local
public interface BlogEntryDao extends Dao<BlogEntry> {

	String NAME = "blogEntryDao";
	String JNDI_NAME = "java:app/untitled1-ejb/BlogEntryDaoBean";

	List<BlogEntry> find(int maxresults, int firstresult);

	Long count();

}

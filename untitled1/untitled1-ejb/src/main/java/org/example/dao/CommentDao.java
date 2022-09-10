package org.example.dao;

import java.util.List;

import javax.ejb.Local;

import org.example.model.BlogEntry;
import org.example.model.Comment;

@Local
public interface CommentDao extends Dao<Comment> {

	String NAME = "commentDao";
	String JNDI_NAME = "java:app/untitled1-ejb/CommentDaoBean";

	List<Comment> findComments(BlogEntry blogEntry);

}

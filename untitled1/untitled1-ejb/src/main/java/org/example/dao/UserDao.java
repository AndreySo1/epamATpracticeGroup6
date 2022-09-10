package org.example.dao;

import javax.ejb.Local;

import org.example.model.User;

@Local
public interface UserDao extends Dao<User> {

	String NAME = "userDao";
	String JNDI_NAME = "java:app/untitled1-ejb/UserDaoBean";

	User findByUsername(String username);

}

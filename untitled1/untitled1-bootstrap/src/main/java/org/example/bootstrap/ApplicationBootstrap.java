package org.example.bootstrap;

import javax.ejb.Local;

@Local
public interface ApplicationBootstrap {
  String NAME = "applicationBootstrap";
  String JNDI_NAME = "java:app/untitled1-bootstrap/ApplicationBootstrapBean";

  void init();
}
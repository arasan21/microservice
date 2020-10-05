package com.arasan.authservice.model;

public enum Role {
	  ROLE_ADMIN, ROLE_CLIENT;

	  public String getAuthority() {
	    return name();
	  }

}
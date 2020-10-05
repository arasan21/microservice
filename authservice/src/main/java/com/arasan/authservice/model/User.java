package com.arasan.authservice.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBL_USERS")
public class User {
	

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;

	  @Size(min = 4, max = 30, message = "Minimum username length: 4 characters")
	  @Column(name = "user_name", unique = true, nullable = false)
	  private String username;
	  
	  @Size(min = 1, max = 50, message = "Minimum username length: 1 characters")
	  @Column(name = "name", nullable = false)
	  private String name;

	  @Column(name = "email", unique = true, nullable = false)
	  private String email;

	  @Size(min = 8, message = "Minimum password length: 8 characters")
	  @Column(name = "password", nullable = false)
	  private String password;
	  
	  @Column(name = "created_at", nullable = false)
	  private Date createdAt;
	  
	  @Column(name = "updated_at",  nullable = false)
	  private Date updatedAt;

	  @Transient
	  @ElementCollection(fetch = FetchType.EAGER)
	  List<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", roles=" + roles + "]";
	}
	
}

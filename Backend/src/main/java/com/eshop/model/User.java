package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="User_spring")
public class User {
	
	@Id
	@NotNull
	private int userId;
	
	@NotEmpty
	@Size(min=4,message="User Name should be Atleast 4")
	private String name;
	
	@NotEmpty
	@Column(name="UserPassword")
	@Size(min=4,max=7,message="Password Should be between 4 to 7")
	private String password;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String role;
	
		public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", gender=" + gender + ", role="
				+ role + "]";
	}
}

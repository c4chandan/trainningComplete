package com.iris.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "NewCustomer")

public class User {

	@Id
	@GeneratedValue
		private int userId;
	private String userName;
	private String password;
	private String gender;
	private String email;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="NewAddress",joinColumns=@JoinColumn(name="CustmerId"))

	private Set <Address> addresSet=new HashSet<>();
	
	private String role;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Address> getAddresSet() {
		return addresSet;
	}
	public void setAddresSet(Set<Address> addresSet) {
		this.addresSet = addresSet;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User(int userId, String userName, String password, String gender, String email, Set<Address> addresSet,
			String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.addresSet = addresSet;
		this.role = role;
	}
	public User() {
		super();
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", email=" + email + ", addresSet=" + addresSet + ", role=" + role + "]";
	}
	
}

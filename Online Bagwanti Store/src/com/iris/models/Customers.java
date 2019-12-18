package com.iris.models;

public class Customers {
	
	private int CustomerId;
	private String CustomerName;
	private String Gender;
	private String Email;
	private String password;
	private String city;
	private String role;

	
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	

	@Override
	public String toString() {
		return "Customers [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", Gender=" + Gender
				+ ", Email=" + Email + ", password=" + password + ", city=" + city + ", role=" + role + "]";
	}
	
}

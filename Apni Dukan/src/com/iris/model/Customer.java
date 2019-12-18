package com.iris.model;

public class Customer {
	
private int customerid;
private String customername;
private String gender;
private String email;
private String password;
private String city;
private String role;
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
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
	return "Customer [customerid=" + customerid + ", customername=" + customername + ", gender=" + gender + ", email="
			+ email + ", password=" + password + ", city=" + city + ", role=" + role + "]";
}





}

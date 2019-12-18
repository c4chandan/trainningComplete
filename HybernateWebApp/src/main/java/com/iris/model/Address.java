package com.iris.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	
	
	private String State;
	private String  city;
	private String pincode;
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

	@Override
	public String toString() {
		return "Address [State=" + State + ", city=" + city + ", pincode=" + pincode + "]";
	}
	

}

package com.iris.model;


public class Engine {


	private String cc;
	private String make;
		
	public void setCc(String cc) {
		this.cc = cc;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Engine(String cc, String make) {
		super();
		this.cc = cc;
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "Engine [cc=" + cc + ", make=" + make + "]";
	}
}

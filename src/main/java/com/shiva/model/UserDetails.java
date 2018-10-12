package com.shiva.model;

public class UserDetails {

	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String pass;
	

	
	



	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


//	public UserDetails(int id, String firstName, String lastName, String email, String dob,String pass) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.dob = dob;
//		this.pass = pass;
//	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
}

package com.wipro.velocity.grow.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Saving Account")
public class SavingAccount {
	
	@Id
	private String id;
	
	
	private String fname;
	private String mname;
	private String lname;
	private String faname;
	@Indexed(unique =true)
	private String phoneNo;
	@Indexed(unique =true)
	private String email;
	private String adhaarNo;
	private Date dob;
	
	
	private String street;
	private String city;
	private int pincode;
	/*
	
	public SavingAccount() {
		//TODO Auto-generated constructor stub
	}
	public SavingAccount(String fname, String mname, String lname, String faname, String phoneNo, String email,
			String adhaarNo, Date dob, String street, String city, int pincode) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.faname = faname;
		this.phoneNo = phoneNo;
		this.email = email;
		this.adhaarNo = adhaarNo;
		this.dob = dob;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFaname() {
		return faname;
	}
	public void setFaname(String faname) {
		this.faname = faname;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdhaarNo() {
		return adhaarNo;
	}
	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}*/

}

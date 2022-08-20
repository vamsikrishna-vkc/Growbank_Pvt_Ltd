package com.wipro.velocity.grow.model;





import java.util.Date;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="User")
public class User {
	
	
	@Id
	private String id;
	private String name;
	private String password;
	private String repassword;
	private String email;
	private Integer accountNo;
	private String tranpassword;
	private String retranpassword;
	private Integer balance;
/*
	
	public User() {
		//TODO Auto-generated constructor stub
	}
	public User(String name,String password, String repassword, String email, Integer accountNo, String tranpassword,
			String retranpassword, Integer balance) {
		super();
		this.name=name;
		this.password = password;
		this.repassword = repassword;
		this.email = email;
		this.accountNo = accountNo;
		this.tranpassword = tranpassword;
		this.retranpassword = retranpassword;
		this.balance=balance;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public 	Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getTranpassword() {
		return tranpassword;
	}
	public void setTranpassword(String tranpassword) {
		this.tranpassword = tranpassword;
	}
	public String getRetranpassword() {
		return retranpassword;
	}
	public void setRetranpassword(String retranpassword) {
		this.retranpassword = retranpassword;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}*/
	
	
}

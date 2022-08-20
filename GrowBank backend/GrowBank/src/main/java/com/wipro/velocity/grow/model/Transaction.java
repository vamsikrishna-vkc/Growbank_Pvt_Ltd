package com.wipro.velocity.grow.model;

import org.springframework.data.annotation.Id;
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
@Document(collection="Transaction")
public class Transaction {
	
	@Id
	private String id;
	private String name;
	private String faccount;
	private String taccount;
	private Integer amount;
	private Date tdate;
	private String instruction;
	private String tPassword;
	private String type;
	private String remark;
	private String status;
	/*
	
	public Transaction() {
		//TODO Auto-generated constructor stub
	}

	public Transaction(String name, String faccount, String taccount, Integer amount, Date tdate, String instruction, String tPassword, String type, String remark, String status) {
		this.name = name;
		this.faccount = faccount;
		this.taccount = taccount;
		this.amount = amount;
		this.tdate = tdate;
		this.instruction = instruction;
		this.tPassword = tPassword;
		this.type = type;
		this.remark = remark;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaccount() {
		return faccount;
	}
	public void setFaccount(String faccount) {
		this.faccount = faccount;
	}
	public String getTaccount() {
		return taccount;
	}
	public void setTaccount(String taccount) {
		this.taccount = taccount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	*/
	
	

}

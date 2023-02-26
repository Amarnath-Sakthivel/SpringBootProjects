package com.foundation.bank.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Validated
@Table(name = "Customer")
public class CustomerEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custID;

	@Column(name = "Account_Number")
	private long accno;

	private double amount;

	@Embedded
	private CustomerName customerName;

	@Size(max = 10)
	@Column(name = "Pan_card")
	private String pan;

	@Size(max = 16)
	@Column(name = "Aadhar_card")
	private String aadhar;

	@Column(name = "Mobile_Number")
	@Size(max = 10)
	private String contact;

	@Embedded
	private CustomerAddress customerAddress;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Account_Customer", joinColumns = { @JoinColumn(name = "account_number") }, inverseJoinColumns = {
			@JoinColumn(name = "account_id") })
	private List<AccountEntity> accounts = new ArrayList<AccountEntity>();

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CustomerName getCustomerName() {
		return customerName;
	}

	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

}

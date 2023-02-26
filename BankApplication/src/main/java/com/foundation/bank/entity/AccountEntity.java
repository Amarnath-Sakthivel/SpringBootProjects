package com.foundation.bank.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Account_Details")
public class AccountEntity implements Serializable {

	@Id
	@Column(name = "Account_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acc_id;
	@Column(name = "Account_Type")
	private String acc_type;
	private Boolean isIndividual;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
	@JsonIgnore
	private Set<CustomerEntity> customers = new HashSet<CustomerEntity>();

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public Boolean getIsIndividual() {
		return isIndividual;
	}

	public void setIsIndividual(Boolean isIndividual) {
		this.isIndividual = isIndividual;
	}

	public Set<CustomerEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CustomerEntity> customers) {
		this.customers = customers;
	}

}

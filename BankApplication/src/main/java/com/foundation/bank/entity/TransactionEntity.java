package com.foundation.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Transaction_Details")
@Entity
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_Id")
	private int trans_id;
	private long from_account;
	private long to_account;
	private double amount;

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public long getFrom_account() {
		return from_account;
	}

	public void setFrom_account(long from_account) {
		this.from_account = from_account;
	}

	public long getTo_account() {
		return to_account;
	}

	public void setTo_account(long to_account) {
		this.to_account = to_account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

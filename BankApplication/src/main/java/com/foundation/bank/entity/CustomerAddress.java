package com.foundation.bank.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
public class CustomerAddress {
	private String city;
	private int pin_code;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

}

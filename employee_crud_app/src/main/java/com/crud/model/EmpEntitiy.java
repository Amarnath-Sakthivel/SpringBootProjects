package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_TBL")
public class EmpEntitiy {

	@Id
	@Column(name = "Resume_Id")
	private int id;
	@Column(name = "Designation")
	private String desgn;
	@Column(name = "Salary")
	private float salary;

	public int getId() {
		return id;
	}

	public String getDesgn() {
		return desgn;
	}

	public float getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDesgn(String desgn) {
		this.desgn = desgn;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}

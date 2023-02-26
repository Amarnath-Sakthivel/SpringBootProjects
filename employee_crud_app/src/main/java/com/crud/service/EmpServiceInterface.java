package com.crud.service;

import java.util.List;

import com.crud.model.EmpEntitiy;

public interface EmpServiceInterface {

	public List<EmpEntitiy> viewAll();

	public EmpEntitiy getEmpById(int id);

	public void saveOrupdate(EmpEntitiy empEntitiy);

	public void delete(int id);

}

package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.DAO.EmpDao;
import com.crud.model.EmpEntitiy;

@Service
@Transactional
public class EmpService implements EmpServiceInterface {

	@Autowired
	private EmpDao dao;

	@Override
	public List<EmpEntitiy> viewAll() {
		return (List<EmpEntitiy>) dao.findAll();
	}

	@Override
	public EmpEntitiy getEmpById(int id) {
		EmpEntitiy empEntitiy=new EmpEntitiy();
		return dao.findById(id).get();
	}

	@Override
	public void saveOrupdate(EmpEntitiy empentitiy) {
		dao.save(empentitiy);

	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);

	}
}

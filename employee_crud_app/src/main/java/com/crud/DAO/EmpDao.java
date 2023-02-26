package com.crud.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.EmpEntitiy;

public interface EmpDao extends JpaRepository<EmpEntitiy, Integer>{

}

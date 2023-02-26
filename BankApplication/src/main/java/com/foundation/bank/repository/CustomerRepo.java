package com.foundation.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foundation.bank.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

	CustomerEntity findByAccno(long id);
}

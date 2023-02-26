package com.foundation.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foundation.bank.entity.TransactionEntity;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, Integer> {

	@Transactional
	@Modifying
	@Query("update CustomerEntity set amount=?1 where accno=?2")
	void updateAmount(double amount, long id);
}

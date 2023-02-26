package com.foundation.bank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foundation.bank.entity.AccountEntity;
import com.foundation.bank.entity.CustomerEntity;


@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

	

}

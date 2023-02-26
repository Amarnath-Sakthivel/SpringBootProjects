package com.foundation.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foundation.bank.entity.AccountEntity;
import com.foundation.bank.entity.CustomerEntity;
import com.foundation.bank.repository.AccountRepo;
import com.foundation.bank.repository.CustomerRepo;

@Service
public class AccountService {

	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CustomerRepo customerRepo;

	public String jointAccount(CustomerEntity customer, List<AccountEntity> accounts) {
		for (CustomerEntity cust : customerRepo.findAll()) {
			if (cust.getPan().equalsIgnoreCase(customer.getPan())
					&& cust.getAccounts().get(0).getAcc_type().equalsIgnoreCase(accounts.get(0).getAcc_type())) {
				customerRepo.save(customer);
				return "joint account account created";
			}
		}
		return "Unable to create account :( !you already have different account type";
	}

	public List<AccountEntity> getAllAccounts() {
		return accountRepo.findAll();
	}

//	public AccountEntity saveAccountDetails(AccountEntity account) {
//		return accountRepo.save(account);
//	}

}

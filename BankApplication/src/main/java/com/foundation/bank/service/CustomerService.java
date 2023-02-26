package com.foundation.bank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foundation.bank.entity.AccountEntity;
import com.foundation.bank.entity.CustomerEntity;
import com.foundation.bank.entity.CustomerName;
import com.foundation.bank.entity.TransactionEntity;
import com.foundation.bank.repository.AccountRepo;
import com.foundation.bank.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CustomerRepo customerRepo;
//	@Autowired
//	TransactionRepo transactionRepo;
	@Autowired
	AccountService accountService;

//	public String saveCustomer(CustomerEntity customer) {
//		if (customer.getAccounts().get(0).getIsIndividual() == true) {
//			customerRepo.save(customer);
//			return "Individual account created";
//		}
//		return accountService.jointAccount(customer, customer.getAccounts());
//	}
	
	

	public List<CustomerEntity> getAllCustomer() {
		return customerRepo.findAll();
	}

	public CustomerEntity findCustomerById(int id) {
		return customerRepo.findById(id).get();
	}

	public void deleteCustomerById(int id) {
		customerRepo.deleteById(id);
	}

	public CustomerEntity updateCustomerById(int id, CustomerEntity customer) throws Exception {
		if (customerRepo.findById(id).isPresent()) {
			CustomerName fullName = new CustomerName();
			fullName.setFname(fullName.getFname());
			fullName.setMname(fullName.getMname());
			fullName.setLname(fullName.getLname());
			customer.setContact(customer.getContact());
			return customerRepo.save(customer);
		} else {
			throw new Exception("Id not Exists");
		}
	}

	public String saveCustomer(CustomerEntity customer, AccountEntity account) {
		customer.getAccounts().add(account);
		account.getCustomers().add(customer);
		customerRepo.save(customer);
		return "created";
		
	}
}

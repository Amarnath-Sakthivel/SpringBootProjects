package com.foundation.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foundation.bank.entity.AccountEntity;
import com.foundation.bank.entity.CustomerEntity;
import com.foundation.bank.entity.TransactionEntity;
import com.foundation.bank.service.AccountService;
import com.foundation.bank.service.CustomerService;
import com.foundation.bank.service.FundTransferService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	CustomerService service;
	
	@Autowired
	FundTransferService fundTransferService;
	
	@Autowired
	AccountService accountService;

	@PostMapping(value = "/customer/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveCustomer(@RequestBody CustomerEntity customer, @RequestBody AccountEntity account) {
		return service.saveCustomer(customer, account);
	}


	@GetMapping("/getAllCustomers")
	public List<CustomerEntity> getAllCustomers() {
		return service.getAllCustomer();
	}
	
//	@GetMapping("/getAllAccounts")
//	public List<AccountEntity> getall(){
//		return accountService.getAllAccounts();
//	}

	@GetMapping("/find/{id}")
	public CustomerEntity findCustomerById(@PathVariable("id") int id) {
		return service.findCustomerById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomerById(@PathVariable("id") int id) {
		service.deleteCustomerById(id);
	}

	@PutMapping("/update/{id}")
	public CustomerEntity updateCustomerById(@PathVariable("id") int id, @RequestBody CustomerEntity customer)
			throws Exception {
		return service.updateCustomerById(id, customer);
	}

	@PostMapping("/transfer")
	public String fundTransfer(@RequestBody TransactionEntity transfer) {
		return fundTransferService.fundTransfer(transfer);

	}

}

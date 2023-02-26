package com.foundation.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foundation.bank.entity.CustomerEntity;
import com.foundation.bank.entity.TransactionEntity;
import com.foundation.bank.repository.AccountRepo;
import com.foundation.bank.repository.CustomerRepo;
import com.foundation.bank.repository.TransactionRepo;

@Service
public class FundTransferService {

	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CustomerRepo customerRepo;

	private String status = "";

	public String fundTransfer(TransactionEntity transfer) {
		if (transfer.getFrom_account() != transfer.getTo_account()) {
			for (CustomerEntity customer : customerRepo.findAll()) {
				if (customer.getAccno() == transfer.getFrom_account()) {
					if (customer.getAmount() >= transfer.getAmount()) {
						double from_amt = customer.getAmount() - transfer.getAmount();
						transactionRepo.updateAmount(from_amt, customer.getAccno());
						status = "Transfered Successfully";
						transactionRepo.save(transfer);
					} else {
						status = "something went wrong- from account";
						break;
					}
				}
				if (customer.getAccno() == transfer.getTo_account()) {
					if (customer.getAmount() >= transfer.getAmount()) {
						double from_amt = customer.getAmount() + transfer.getAmount();
						transactionRepo.updateAmount(from_amt, customer.getAccno());
						status = "Transfered Successfully";
						transactionRepo.save(transfer);
					} else {
						status = "something went wrong- to account";
						break;
					}
				}
			}
		} else {
			status = "Id not exists";
		}
		return status;
	}
}

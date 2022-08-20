package com.wipro.velocity.grow.controller;

import com.wipro.velocity.grow.model.Transaction;
import com.wipro.velocity.grow.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@PostMapping("/addtransaction")
	public String saveTransaction(@RequestBody Transaction transaction) {
		return transactionService.saveTransaction(transaction);
	}
	
	@GetMapping("/findAllTransaction")
	public List<Transaction> gettransaction(){
		return transactionService.findAll();
	}
	
	@PostMapping("/deposit")
	public String savedeposit(@RequestBody Transaction deposit) {
		return transactionService.savedeposit(deposit);
	}

	@PostMapping("/withdraw")
	public String withdraw(@RequestBody Transaction deposit) {
		return transactionService.withdraw(deposit);
	}
}

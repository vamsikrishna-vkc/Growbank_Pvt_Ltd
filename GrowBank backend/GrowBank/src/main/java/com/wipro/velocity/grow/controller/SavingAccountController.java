package com.wipro.velocity.grow.controller;

import com.wipro.velocity.grow.model.SavingAccount;
import com.wipro.velocity.grow.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SavingAccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/savingaccount")
	public String saveAccount(@RequestBody SavingAccount saveaccount) {
      return accountService.saveAccount(saveaccount);
	}
	@GetMapping("/findAllAccount")
	public List<SavingAccount> getUser(){
		return accountService.getUser();
	}

}

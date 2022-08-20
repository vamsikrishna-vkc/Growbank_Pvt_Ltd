package com.wipro.velocity.grow.services;

import com.wipro.velocity.grow.model.SavingAccount;
import com.wipro.velocity.grow.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private SavingAccountRepository srepo;

    public String saveAccount(SavingAccount saveaccount){
        srepo.save(saveaccount);
        return "Account Created  Successfully";
    }

    public List<SavingAccount> getUser(){
        return srepo.findAll();
    }
}

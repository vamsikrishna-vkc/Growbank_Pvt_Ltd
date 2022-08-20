package com.wipro.velocity.grow.repository;

import com.wipro.velocity.grow.model.SavingAccount;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SavingAccountRepository extends MongoRepository<SavingAccount, String> {



}

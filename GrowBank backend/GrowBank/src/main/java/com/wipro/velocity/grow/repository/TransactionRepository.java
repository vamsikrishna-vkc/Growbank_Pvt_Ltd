package com.wipro.velocity.grow.repository;

import com.wipro.velocity.grow.model.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}

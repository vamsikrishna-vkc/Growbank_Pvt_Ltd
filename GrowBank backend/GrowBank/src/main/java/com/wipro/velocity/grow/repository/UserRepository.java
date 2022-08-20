package com.wipro.velocity.grow.repository;

import com.wipro.velocity.grow.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

	public Optional<User> findByEmail(String email);


	public Optional<User> findByaccountNo(Integer accountNo);
}

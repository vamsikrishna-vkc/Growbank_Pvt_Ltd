package com.wipro.velocity.grow;

import com.wipro.velocity.grow.model.SavingAccount;
import com.wipro.velocity.grow.services.AccountService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
class GrowBankApplicationTests {

	@Autowired
	AccountService accountService;

	@Test
	public void testSaveAccount() {
		SavingAccount s=new SavingAccount();
		s.setCity("demo");
		s.setAdhaarNo("12323");
		s.setDob(new Date());
		s.setEmail("demo@gmail.com");
		s.setFaname("demo");
		s.setFaname("demo");
		s.setPhoneNo("7000564556");
		Assert.assertEquals(accountService.saveAccount(s),"Account Created  Successfully");
	}

	@Test
	public void testGetUser(){
		Assert.assertEquals(accountService.getUser().size(),1);
	}
}

package com.wipro.velocity.grow;

import com.wipro.velocity.grow.model.Transaction;
import com.wipro.velocity.grow.model.User;
import com.wipro.velocity.grow.services.TransactionService;
import com.wipro.velocity.grow.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class TransactionServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    public void createUsers(){
        User u=new User();
        u.setBalance(4000);
        u.setEmail("demo3@gmail.com");
        u.setPassword("hello");
        u.setAccountNo(1);
        u.setName("demo");
        u.setTranpassword("hello");
        userService.saveUser(u);
        User u1=new User();
        u1.setBalance(4000);
        u1.setEmail("demo4@gmail.com");
        u1.setPassword("hello");
        u1.setAccountNo(2);
        u1.setName("demo1");
        u1.setTranpassword("hello");
        userService.saveUser(u1);
    }

    public Transaction getTransaction(){
        Transaction t=new Transaction();
        t.setFaccount("demo3@gmail.com");
        t.setTaccount("demo4@gmail.com");
        t.setAmount(1000);
        t.setTPassword("hello");
        t.setType("UPI");
        return t;
    }
    @Test
    public void testSaveTransaction(){

        Assert.assertEquals(transactionService.saveTransaction(getTransaction()),"Transaction Successful");
    }

    @Test
    void testSaveTransactionWithWrongCreds(){
        Transaction t=getTransaction();
        t.setTPassword("wrong");
        Assert.assertEquals(transactionService.saveTransaction(t),"transaction failed!! Incorrect pin");
    }

    @Test
    public void testSaveTransactionInsufficientBalance(){
        Transaction t=getTransaction();
        t.setTPassword("hello");
        t.setAmount(100000);
        Assert.assertEquals(transactionService.saveTransaction(t),"transaction failed!! Insufficient account balance");
    }

    @Test
    public void testFindALL(){
        createUsers();
        Assert.assertEquals(transactionService.findAll().size(),0);
    }

    @Test
    public void testSaveDeposit() throws Exception{
        Transaction t=getTransaction();
        Assert.assertEquals(transactionService.savedeposit(t),"deposit Successful");
        int i=userService.getUserByEmail("demo3@gmail.com").getBody().getBalance();
        Assert.assertEquals(i,3000 );
    }

    @Test
    public void testWithdraw() throws Exception{
        Transaction t=getTransaction();
        t.setType("withdrawl");
        Assert.assertEquals(transactionService.withdraw(t),"withdrawl Successful");
        int i=userService.getUserByEmail("demo3@gmail.com").getBody().getBalance();
        Assert.assertEquals(i,2000);
    }
}

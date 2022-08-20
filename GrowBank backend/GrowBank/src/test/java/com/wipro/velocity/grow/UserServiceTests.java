package com.wipro.velocity.grow;

import com.wipro.velocity.grow.model.User;
import com.wipro.velocity.grow.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class UserServiceTests {

    @Autowired
    UserService userService;

    public User getUser(){
      User u=new User();
      u.setBalance(4000);
      u.setEmail("demo@gmail.com");
      u.setPassword("hello");
      u.setAccountNo(144553);
      u.setName("demo");
      u.setTranpassword("hello");
      return u;
    }

    @Test
    public void testSaveUser(){
        User u=getUser();
        Assert.assertEquals(userService.saveUser(u).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetUserByEmail() throws Exception{
        User u=getUser();
        u.setEmail("demo1@gmail.com");
        userService.saveUser(u);
       Assert.assertEquals(userService.getUserByEmail("demo1@gmail.com").getBody().getPassword(),"hello");
    }

    @Test
    public void testFindAll(){
        Assert.assertEquals(userService.findAll().size(),4);
    }

    @Test
    public void testLoginUser() throws Exception{
        Assert.assertEquals(userService.loginUser(getUser()),true);
    }

    @Test
    public void testFalseCredLogin() throws  Exception{
        User u=new User();
        u.setPassword("wrongpassword");
        u.setEmail("demo@gmail.com");
        Assert.assertEquals(userService.loginUser(u),false);
    }
}

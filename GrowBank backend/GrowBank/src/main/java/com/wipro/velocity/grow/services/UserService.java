package com.wipro.velocity.grow.services;

import com.wipro.velocity.grow.exception.ResourceNotFoundException;
import com.wipro.velocity.grow.model.User;
import com.wipro.velocity.grow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository urepo;

    public ResponseEntity<User> getUserByEmail(String email) throws ResourceNotFoundException{

        Optional<User> user =urepo.findByEmail(email);
        if(!user.isPresent())
            throw new ResourceNotFoundException
                    ("User Not Found for this id: "+email);

        return ResponseEntity.ok().body(user.get());
    }

    public ResponseEntity<String> saveUser(User user){
        urepo.save(user);
        return new ResponseEntity<String>("User registered Successfully", HttpStatus.OK);
    }

    public List<User> findAll(){
        return urepo.findAll();
    }

    public Boolean loginUser(User user) throws ResourceNotFoundException{
        Boolean isLogin = false;
        String email=user.getEmail();
        String password=user.getPassword();
        User u=urepo.findByEmail(email).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Unknown User "));
        if(email.equals(u.getEmail())&&password.equals(u.getPassword())) {
            isLogin=true;
        }
        return isLogin;
    }


}

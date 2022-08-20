package com.wipro.velocity.grow.services;

import com.wipro.velocity.grow.model.Transaction;
import com.wipro.velocity.grow.model.User;
import com.wipro.velocity.grow.repository.TransactionRepository;
import com.wipro.velocity.grow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    public TransactionRepository trepo;

    @Autowired
    UserRepository userRepository;

    public String saveTransaction(Transaction transaction){
    	trepo.save(transaction);
        User fuser;
        User tuser;
        String faccount=transaction.getFaccount();
        String taccount=transaction.getTaccount();
        if(transaction.getType().equalsIgnoreCase("UPI"))
        {
            fuser=userRepository.findByEmail(faccount).get();
            tuser=userRepository.findByEmail(taccount).get();
        }else{
            fuser=userRepository.findByaccountNo(Integer.parseInt(faccount)).get();
            tuser=userRepository.findByaccountNo(Integer.parseInt(taccount)).get();
        }
        if(!fuser.getTranpassword().equals(transaction.getTPassword()))
        {
            transaction.setStatus("transaction failed!! Incorrect pin");
            return "transaction failed!! Incorrect pin";
        }
        if(fuser.getBalance()< transaction.getAmount())
        {
            transaction.setStatus("transaction failed!! Insufficient account balance");
            return "transaction failed!! Insufficient account balance";
        }
        fuser.setBalance(fuser.getBalance()-transaction.getAmount());
        tuser.setBalance(tuser.getBalance()+transaction.getAmount());

        userRepository.save(fuser);
        userRepository.save(tuser);
        transaction.setStatus("Transaction Successful");
        trepo.save(transaction);
        return "Transaction Successful";
    }

    public List<Transaction> findAll(){
        return trepo.findAll();
    }

    public String savedeposit(Transaction deposit){
        trepo.save(deposit);
        User user;
        if(deposit.getType().toUpperCase().equals("UPI"))
            user=userRepository.findByEmail(deposit.getFaccount()).get();
        else
            user=userRepository.findByaccountNo(Integer.parseInt(deposit.getFaccount())).get();
        
        user.setBalance(deposit.getAmount()+user.getBalance());
        userRepository.save(user);
        deposit.setStatus("deposit to faccount successful");
        return "deposit Successful";
    }

    public String withdraw(Transaction deposit){
        trepo.save(deposit);
        User user=null;
        if(deposit.getType().equalsIgnoreCase("withdrawl"))
            user=userRepository.findByEmail(deposit.getFaccount()).get();
        if(deposit.getAmount()>user.getBalance())
            return "withdrawl Failed";
        user.setBalance(user.getBalance()-deposit.getAmount());
        userRepository.save(user);
        deposit.setStatus("withdrawl from faccount successful");
        return "withdrawl Successful";
    }

}

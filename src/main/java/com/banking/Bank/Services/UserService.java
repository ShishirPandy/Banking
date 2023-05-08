package com.banking.Bank.Services;

import com.banking.Bank.Entity.Bank;

import com.banking.Bank.Entity.UserEntity;
import com.banking.Bank.Repo.BankRepo;
import com.banking.Bank.Repo.users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserService
{
    @Autowired
    private users userRepo;
    @Autowired
    private BankRepo Repo;
    public String addnewuser(Bank bank){
        if(Repo.existsByBankIFSC(bank.getBankIFSC()))
        {
            Bank bank1 =  Repo.findByBankIFSC(bank.getBankIFSC());
            for(UserEntity user : bank.getUserEntityList()){
                if(!this.userRepo.existsByAccount(user.getAccount())){
                user.setBank(bank1);
                userRepo.save(user);}
                else{
                    String a= user.getAccount();
                    String b="account with this account number"+a+"exits";
                    System.out.println(b);
                }
            }
        }
        else
        Repo.save(bank);
        return "User saved";
    }
    public List<Bank> gETaLL(){
        List<Bank>ans=this.Repo.findAll();
        return ans;
    }
    public String addamount(String account,int amount){
        if(userRepo.existsByAccount(account)){
        UserEntity user1;
        user1=this.userRepo.findByAccount(account);
        System.out.println(user1+"Howw");
          int currentamount=user1.getAmount();
          currentamount+=amount;
          user1.setAmount(currentamount);
          userRepo.save(user1);
          return "amount updated";}
        else{
            return "no account exit";
        }
    }
    public UserEntity getdetails(String account){
        if(userRepo.existsByAccount(account)){
            UserEntity ans=this.userRepo.findByAccount(account);
            return ans;
        }
        else{

            return null;}
    }
    public String delete(String account){
        if(userRepo.existsByAccount(account)){
            this.userRepo.deleteByAccount(account);
            return "user deleted";
        }
        else{
            return "user not EXIST";
        }
    }
    }

package com.banking.Bank.Controller;

import com.banking.Bank.Entity.Bank;
import com.banking.Bank.Entity.UserEntity;
import com.banking.Bank.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class Api {
    @Autowired
    private UserService userService;
    @PostMapping("/adduser")
    @Transactional
    ResponseEntity<String>addnewuser(@RequestBody Bank bank){
        String a=this.userService.addnewuser(bank);
        return new ResponseEntity<String>(a, HttpStatus.CREATED);
    }
   // @PostMapping("/addbank")
    //ResponseEntity<String>addbank(Bank bank){
      //  String b=this.userService.addbank(bank);
        //return new ResponseEntity<String>(b,HttpStatus.CREATED);
    //}
    @GetMapping("/getall")
        ResponseEntity<List>gETaLL(){
           List<Bank>ans=this.userService.gETaLL();
            return new ResponseEntity<List>(ans,HttpStatus.OK);
       }
       @PutMapping("/addAmount/{account}")
    ResponseEntity<String>addAmount(@PathVariable("account")String account,@RequestParam int amount){
        String a=this.userService.addamount(account,amount);
        return new ResponseEntity<>(a,HttpStatus.OK);
       }
       @GetMapping("/getdetail")
    ResponseEntity<UserEntity>getdetails(@RequestParam  String account){
        UserEntity a=this.userService.getdetails(account);
        return new ResponseEntity<UserEntity>(a,HttpStatus.OK);
       }
       @DeleteMapping("/delete")
    ResponseEntity<String>delete(@RequestParam String account){
        String a= this.userService.delete(account);
        return new ResponseEntity<>(a,HttpStatus.OK);

    }

   }

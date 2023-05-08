package com.banking.Bank.Repo;

import com.banking.Bank.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankRepo extends JpaRepository<Bank,Integer>{
Bank findByBankIFSC(String  bankIFSC);
Boolean existsByBankIFSC(String bankIFSC);
}

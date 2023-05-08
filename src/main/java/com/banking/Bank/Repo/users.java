package com.banking.Bank.Repo;

import com.banking.Bank.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface users extends JpaRepository<UserEntity,Integer> {
    Boolean existsByAccount(String account);

    UserEntity findByAccount(String account);
    void deleteByAccount(String account);

}


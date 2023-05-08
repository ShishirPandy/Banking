package com.banking.Bank.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String bankname;

    private String bankaddress;

    private String bankIFSC;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="bank_id")
    private List<UserEntity> userEntityList;
    public Bank() {
        this.userEntityList = new ArrayList<>();
    }
}

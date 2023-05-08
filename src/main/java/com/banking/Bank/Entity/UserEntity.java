package com.banking.Bank.Entity;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import jakarta.persistence.*;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String name;
    private String email;
    private String account;
    private String bankIFSC;
    private int amount;
    private int pin;
    @JsonIgnore
    @ManyToOne()
    private Bank bank;
}

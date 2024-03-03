package com.example.BankAccount.deposit;

import jakarta.persistence.*;

@Entity
@Table
public class Deposit {
    @jakarta.persistence.Id
    @SequenceGenerator(
            name = "deposit_sequence",
            sequenceName = "deposit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "deposit_sequence"
    )
    private Long Id;
}

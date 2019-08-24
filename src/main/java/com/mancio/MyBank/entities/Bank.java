package com.mancio.MyBank.entities;

import javax.persistence.*;

@Table(name = "Bank")
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Bank_ID")
    private long bank_id;
    @Column(name = "Bank_Details")
    private String bk_det;


}

package com.mancio.MyBank.entities;

import org.hibernate.Transaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @Column(name = "account_number", updatable = false, nullable = false)
    private int ac_number;
    @Column(name = "country_code", updatable = false, nullable = false)
    private String country;
    @Column(name = "user_ID")
    private long user_id;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private User user;

    @OneToMany(mappedBy = "bank_account")
    private Set<Transaction> transaction;

    public int getAc_number() {
        return ac_number;
    }

    public void setAc_number(int ac_number) {
        this.ac_number = ac_number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Transaction> getTransactions() {
        return transaction;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transaction = transactions;
    }
}

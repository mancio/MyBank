package com.mancio.MyBank.entities;

import org.hibernate.Transaction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Bank_Account")
public class Bank_Account {

    @Id
    @Column(name = "Account_Number", updatable = false)
    private int ac_number;
    @Column(name = "Country_Code")
    private String country;
    @Column(name = "User_ID")
    private long user_id;
    @Column(name = "Balance")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Country_Code", nullable = false)
    private Account_Country_Code account_country_code;

    @OneToMany(mappedBy = "Bank_Account")
    private Set<Transaction> transactions;

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

    public Account_Country_Code getAccount_country_code() {
        return account_country_code;
    }

    public void setAccount_country_code(Account_Country_Code account_country_code) {
        this.account_country_code = account_country_code;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}

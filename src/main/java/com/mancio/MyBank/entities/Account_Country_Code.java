package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Account_Country_Code")
public class Account_Country_Code {

    @Id
    @Column(name = "Country_Code")
    private String country_code;
    @Column(name = "Currency")
    private String currency;

    @OneToMany(mappedBy = "Account_Country_Code")
    private Set<Bank_Account> bank_accounts;
    @OneToMany(mappedBy = "Account_Country_Code")
    private Set<Transaction> transactions;

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<Bank_Account> getBank_accounts() {
        return bank_accounts;
    }

    public void setBank_accounts(Set<Bank_Account> bank_accounts) {
        this.bank_accounts = bank_accounts;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}

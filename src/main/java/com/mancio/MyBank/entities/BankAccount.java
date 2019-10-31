package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "bankaccount")
public class BankAccount {

    @Id
    @Column(name = "accountnumber", updatable = false, nullable = false)
    private int acnumber;
    @Column(name = "countrycode", updatable = false, nullable = false)
    private String country;
    @Column(name = "userid")
    private long userid;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable=false, updatable=false)
    private User user;

    @OneToMany(mappedBy = "bankaccount")
    private Set<Transaction> transaction;

    public int getAcnumber() {
        return acnumber;
    }

    public void setAcnumber(int acnumber) {
        this.acnumber = acnumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }
}

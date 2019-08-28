package com.mancio.MyBank.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "Bank_Account")
public class BkAccount {

    @Id
    @Column(name = "account_number", updatable = false)
    private BigDecimal number;
    @Column(name = "currency")
    private String currency;
    @Column(name = "opening_date")
    private LocalDate opdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getOpdate() {
        return opdate;
    }

    public void setOpdate(LocalDate opdate) {
        this.opdate = opdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.mancio.MyBank.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "bank_account")
@Entity
public class BkAccount {

    @Id
    @Column(name = "account_number", updatable = false)
    private BigDecimal number;
    @Column(name = "currency")
    private String currency;
    @Column(name = "opening_date")
    private LocalDate opdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
}

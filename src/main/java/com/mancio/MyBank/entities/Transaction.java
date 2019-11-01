package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionid", nullable = false, updatable = false)
    private long trid;
    @Column(name = "senderaccountnumber", nullable = false, updatable = false)
    private String sendacnum;
    @Column(name = "transferdate", nullable = false, updatable = false)
    private LocalDate date;
    @Column(name = "receivername", nullable = false, updatable = false)
    private String recname;
    @Column(name = "receiveraccountnumber", nullable = false, updatable = false)
    private String recacnum;
    @Column(name = "transamount", nullable = false, updatable = false)
    private BigDecimal amount;
    @Column(name = "transdescription", nullable = false, updatable = false)
    private String desc;
    @Column(name = "transstatus", nullable = false, updatable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderaccountnumber", insertable = false, updatable = false)
    private BankAccount bankaccount;

    public long getTrid() {
        return trid;
    }

    public void setTrid(long trid) {
        this.trid = trid;
    }

    public String getSendacnum() {
        return sendacnum;
    }

    public void setSendacnum(String sendacnum) {
        this.sendacnum = sendacnum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRecname() {
        return recname;
    }

    public void setRecname(String recname) {
        this.recname = recname;
    }

    public String getRecacnum() {
        return recacnum;
    }

    public void setRecacnum(String recacnum) {
        this.recacnum = recacnum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BankAccount getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(BankAccount bankaccount) {
        this.bankaccount = bankaccount;
    }
}

package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_ID", nullable = false, updatable = false)
    private long tr_id;
    @Column(name = "sender_account_number", nullable = false, updatable = false)
    private String send_ac_num;
    @Column(name = "transfer_date", nullable = false, updatable = false)
    private LocalDate date;
    @Column(name = "receiver_name", nullable = false, updatable = false)
    private String rec_name;
    @Column(name = "receiver_account_number", nullable = false, updatable = false)
    private String rec_ac_num;
    @Column(name = "trans_amount", nullable = false, updatable = false)
    private BigDecimal amount;
    @Column(name = "trans_description", nullable = false, updatable = false)
    private String desc;
    @Column(name = "trans_status", nullable = false, updatable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    private Bank_Account bank_account;

    public long getTr_id() {
        return tr_id;
    }

    public void setTr_id(long tr_id) {
        this.tr_id = tr_id;
    }

    public String getSend_ac_num() {
        return send_ac_num;
    }

    public void setSend_ac_num(String send_ac_num) {
        this.send_ac_num = send_ac_num;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRec_name() {
        return rec_name;
    }

    public void setRec_name(String rec_name) {
        this.rec_name = rec_name;
    }

    public String getRec_ac_num() {
        return rec_ac_num;
    }

    public void setRec_ac_num(String rec_ac_num) {
        this.rec_ac_num = rec_ac_num;
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

    public Bank_Account getBank_account() {
        return bank_account;
    }

    public void setBank_account(Bank_Account bank_account) {
        this.bank_account = bank_account;
    }
}

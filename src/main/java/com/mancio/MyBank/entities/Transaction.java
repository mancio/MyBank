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
    @Column(name = "sender_account_number", nullable = false)
    private String send_ac_num;
    @Column(name = "Access_Description")
    private String ac_desc;
    @Column(name = "Date", nullable = false, updatable = false)
    private LocalDate date;
    @Column(name = "Receiver_Name")
    private String rec_name;
    @Column(name = "Receiver_Account_Code")
    private String rec_ac_code;
    @Column(name = "Receiver_Account_Number")
    private int rec_ac_num;
    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "Description")
    private String desc;
    @Column(name = "Status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Number", nullable = false)
    private Bank_Account bank_account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Country_Code", nullable = false)
    private Account_Country_Code account_country_code;

    public long getTr_id() {
        return tr_id;
    }

    public void setTr_id(long tr_id) {
        this.tr_id = tr_id;
    }

    public String getSend_ac_code() {
        return send_ac_code;
    }

    public void setSend_ac_code(String send_ac_code) {
        this.send_ac_code = send_ac_code;
    }

    public int getSend_ac_num() {
        return send_ac_num;
    }

    public void setSend_ac_num(int send_ac_num) {
        this.send_ac_num = send_ac_num;
    }

    public String getAc_desc() {
        return ac_desc;
    }

    public void setAc_desc(String ac_desc) {
        this.ac_desc = ac_desc;
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

    public String getRec_ac_code() {
        return rec_ac_code;
    }

    public void setRec_ac_code(String rec_ac_code) {
        this.rec_ac_code = rec_ac_code;
    }

    public int getRec_ac_num() {
        return rec_ac_num;
    }

    public void setRec_ac_num(int rec_ac_num) {
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

    public Account_Country_Code getAccount_country_code() {
        return account_country_code;
    }

    public void setAccount_country_code(Account_Country_Code account_country_code) {
        this.account_country_code = account_country_code;
    }
}

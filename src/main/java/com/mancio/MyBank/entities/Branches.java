package com.mancio.MyBank.entities;

import javax.persistence.*;

@Table(name = "Branches")
@Entity
public class Branches {
    @Id
    @Column(name = "Branch_ID")
    private long branch_id;
    @Column(name = "Address_ID")
    private long address_id;
    @Column(name = "Bank_ID")
    private long bank_id;
    @Column(name = "Branch_Type_Code")
    private long branch_code;
    @Column(name = "Branch_Details")
    private long branch_details;

    @ManyToOne
    @JoinColumn(name = "Bank_ID", nullable = false)
    private Bank bank;

    public long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public long getBank_id() {
        return bank_id;
    }

    public void setBank_id(long bank_id) {
        this.bank_id = bank_id;
    }

    public long getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(long branch_code) {
        this.branch_code = branch_code;
    }

    public long getBranch_details() {
        return branch_details;
    }

    public void setBranch_details(long branch_details) {
        this.branch_details = branch_details;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
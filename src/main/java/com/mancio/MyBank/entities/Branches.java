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
    private String branch_code;
    @Column(name = "Branch_Details")
    private String branch_details;

    @ManyToOne
    @JoinColumn(name = "Bank_ID", nullable = false)
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "Address_ID", nullable = false)
    private Addresses addresses;

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

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_details() {
        return branch_details;
    }

    public void setBranch_details(String branch_details) {
        this.branch_details = branch_details;
    }

    public Bank getBank() {
        return bank;
    }


    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
}

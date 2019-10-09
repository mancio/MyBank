package com.mancio.MyBank.entities;

import javax.persistence.*;


@Entity
@Table(name = "Branches")
public class Branches {
    @Id
    @Column(name = "Branch_ID")
    private long branch_id;
    @Column(name = "B_Address_ID")
    private long b_address_id;
    @Column(name = "Bank_ID")
    private long bank_id;
    @Column(name = "Branch_Type_Code")
    private String branch_code;
    @Column(name = "Branch_Details")
    private String branch_details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Bank_ID", nullable = false)
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Address_ID", nullable = false)
    private Addresses addresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_Type_Code", nullable = false)
    private Branch_Services brserv;

    public long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

    public long getB_address_id() {
        return b_address_id;
    }

    public void setB_address_id(long b_address_id) {
        this.b_address_id = b_address_id;
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

    public Branch_Services getBrserv() {
        return brserv;
    }

    public void setBrserv(Branch_Services brserv) {
        this.brserv = brserv;
    }
}

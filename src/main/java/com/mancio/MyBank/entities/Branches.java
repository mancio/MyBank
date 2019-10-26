package com.mancio.MyBank.entities;

import javax.persistence.*;


@Entity
@Table(name = "branches")
public class Branches {
    @Id
    @Column(name = "branch_ID", nullable = false, updatable = false)
    private long branch_id;
    @Column(name = "b_address_ID")
    private long b_address_id;
    @Column(name = "bank_ID")
    private long bank_id;
    @Column(name = "branch_type_code", nullable = false)
    private String branch_code;
    @Column(name = "branch_details")
    private String branch_details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_ID", nullable = false)
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_address_ID", nullable = false)
    private Branch_Addresses b_addresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_type_code", nullable = false)
    private Branch_Services brserv;

    @OneToMany(mappedBy = "branches")
    private User user;

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

    public Branch_Addresses getB_addresses() {
        return b_addresses;
    }

    public void setB_addresses(Branch_Addresses b_addresses) {
        this.b_addresses = b_addresses;
    }

    public Branch_Services getBrserv() {
        return brserv;
    }

    public void setBrserv(Branch_Services brserv) {
        this.brserv = brserv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

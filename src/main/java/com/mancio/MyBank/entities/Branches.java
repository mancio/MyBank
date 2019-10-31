package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "branches")
public class Branches {
    @Id
    @Column(name = "branchid", nullable = false, updatable = false)
    private long branchid;
    @Column(name = "baddressid")
    private long baddressid;
    @Column(name = "bankid")
    private long bankid;
    @Column(name = "branchtypecode")
    private String brtpcode;
    @Column(name = "branchdetails")
    private String branchdetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankid", nullable = false, insertable=false, updatable=false)
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baddressid", nullable = false, insertable=false, updatable=false)
    private BranchAddresses branchaddresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchtypecode", nullable = false, insertable=false, updatable=false)
    private BranchServices branchservices;

    @OneToMany(mappedBy = "branches")
    private Set<User> user;

    public long getBranchid() {
        return branchid;
    }

    public void setBranchid(long branchid) {
        this.branchid = branchid;
    }

    public long getBaddressid() {
        return baddressid;
    }

    public void setBaddressid(long baddressid) {
        this.baddressid = baddressid;
    }

    public long getBankid() {
        return bankid;
    }

    public void setBankid(long bankid) {
        this.bankid = bankid;
    }

    public String getBrtpcode() {
        return brtpcode;
    }

    public void setBrtpcode(String brtpcode) {
        this.brtpcode = brtpcode;
    }

    public String getBranchdetails() {
        return branchdetails;
    }

    public void setBranchdetails(String branchdetails) {
        this.branchdetails = branchdetails;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BranchAddresses getBranchaddresses() {
        return branchaddresses;
    }

    public void setBranchaddresses(BranchAddresses branchaddresses) {
        this.branchaddresses = branchaddresses;
    }

    public BranchServices getBranchservices() {
        return branchservices;
    }

    public void setBranchservices(BranchServices branchservices) {
        this.branchservices = branchservices;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}

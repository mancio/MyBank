package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bankid")
    private long bankid;
    @Column(name = "bankdetails")
    private String bkdet;

    @OneToMany(mappedBy = "bank")
    private Set<Branches> branches;

    public long getBankid() {
        return bankid;
    }

    public void setBankid(long bankid) {
        this.bankid = bankid;
    }

    public String getBkdet() {
        return bkdet;
    }

    public void setBkdet(String bkdet) {
        this.bkdet = bkdet;
    }

    public Set<Branches> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branches> branches) {
        this.branches = branches;
    }

    


}

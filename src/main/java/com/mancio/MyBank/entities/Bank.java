package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

@Table(name = "Bank")
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Bank_ID")
    private long bank_id;
    @Column(name = "Bank_Details")
    private String bk_det;
    @OneToMany(mappedBy = "Bank")
    private Set<Branches> branches;

    public long getBank_id() {
        return bank_id;
    }

    public void setBank_id(long bank_id) {
        this.bank_id = bank_id;
    }

    public String getBk_det() {
        return bk_det;
    }

    public void setBk_det(String bk_det) {
        this.bk_det = bk_det;
    }

    public Set<Branches> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branches> branches) {
        this.branches = branches;
    }

    


}

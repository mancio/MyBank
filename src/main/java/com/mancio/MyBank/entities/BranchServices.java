package com.mancio.MyBank.entities;



import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "branchservices")
public class BranchServices {

    @Id
    @Column(name = "branchtypecode", nullable = false, columnDefinition = "VARCHAR(20)")
    private String brtpcode;
    @Column(name = "servicelist", columnDefinition = "VARCHAR(120)")
    private String slist;
    @OneToMany(mappedBy = "branchservices")
    private Set<Branches> branches;


    public String getBrtpcode() {
        return brtpcode;
    }

    public void setBrtpcode(String brtpcode) {
        this.brtpcode = brtpcode;
    }

    public String getSlist() {
        return slist;
    }

    public void setSlist(String slist) {
        this.slist = slist;
    }

    public Set<Branches> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branches> branches) {
        this.branches = branches;
    }
}

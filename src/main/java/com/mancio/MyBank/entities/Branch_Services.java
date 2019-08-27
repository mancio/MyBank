package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Branch_Services")
public class Branch_Services {
    @Id
    @Column(name = "Branch_Type_Code")
    private String br_tp_code;
    @Column(name = "Service_List")
    private String slist;

    @OneToMany(mappedBy = "Branch_Services")
    private Set<Branch_Services> brserv;

    public String getBr_tp_code() {
        return br_tp_code;
    }

    public void setBr_tp_code(String br_tp_code) {
        this.br_tp_code = br_tp_code;
    }

    public String getSlist() {
        return slist;
    }

    public void setSlist(String slist) {
        this.slist = slist;
    }

    public Set<Branch_Services> getBrserv() {
        return brserv;
    }

    public void setBrserv(Set<Branch_Services> brserv) {
        this.brserv = brserv;
    }
}

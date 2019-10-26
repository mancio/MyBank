package com.mancio.MyBank.entities;



import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "branch_services")
public class Branch_Services {

    @Id
    @Column(name = "branch_type_code", nullable = false)
    private String br_tp_code;
    @Column(name = "service_list")
    private String slist;
    @OneToMany(mappedBy = "branch_services")
    private Set<Branches> brserv;


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

    public Set<Branches> getBrserv() {
        return brserv;
    }

    public void setBrserv(Set<Branches> brserv) {
        this.brserv = brserv;
    }
}

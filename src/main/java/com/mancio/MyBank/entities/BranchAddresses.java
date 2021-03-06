package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branchaddresses")
public class BranchAddresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "baddressid", updatable = false, nullable = false, columnDefinition = "BIGINT(20)")
    private long bankadrid;
    @Column(name = "street", columnDefinition = "VARCHAR(30)")
    private String street;
    @Column(name = "city", columnDefinition = "VARCHAR(30)")
    private String city;
    @Column(name = "zip", columnDefinition = "VARCHAR(30)")
    private String zip;
    @Column(name = "region", nullable = false, columnDefinition = "VARCHAR(30)")
    private String region;
    @Column(name = "country", nullable = false, columnDefinition = "VARCHAR(30)")
    private String country;


    @OneToMany(mappedBy = "branchaddresses")
    private Set<Branches> branches;

    public long getBankadrid() {
        return bankadrid;
    }

    public void setBankadrid(long bankadrid) {
        this.bankadrid = bankadrid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Branches> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branches> branches) {
        this.branches = branches;
    }
}

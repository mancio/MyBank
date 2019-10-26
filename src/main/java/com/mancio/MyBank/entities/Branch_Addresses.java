package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branch_addresses")
public class Branch_Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "b_address_ID", updatable = false, nullable = false)
    private long b_ad_id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip")
    private String zip;
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "state", nullable = false)
    private String state;

    @OneToMany(mappedBy = "branch_addresses")
    private Set<Branches> branches;

    public long getB_ad_id() {
        return b_ad_id;
    }

    public void setB_ad_id(long b_ad_id) {
        this.b_ad_id = b_ad_id;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<Branches> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branches> branches) {
        this.branches = branches;
    }
}

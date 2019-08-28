package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

public class Branches_Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "B_Address_ID", updatable = false)
    private long b_ad_id;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;
    @Column(name = "Zip")
    private String zip;
    @Column(name = "Region")
    private String region;
    @Column(name = "Country")
    private String country;
    @Column(name = "State")
    private String state;

    @OneToMany(mappedBy = "Branches_Addresses")
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

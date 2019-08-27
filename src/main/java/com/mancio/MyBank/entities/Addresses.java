package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Addresses")
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Address_ID")
    private long address_id;
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

    @OneToMany(mappedBy = "Addresses")
    private Set<Branches> branches;

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
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

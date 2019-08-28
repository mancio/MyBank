package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

public class User_Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "U_Address_ID")
    private long u_ad_id;
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

    @OneToMany(mappedBy = "User_Addresses")
    private Set<User> user;

    public long getU_ad_id() {
        return u_ad_id;
    }

    public void setU_ad_id(long u_ad_id) {
        this.u_ad_id = u_ad_id;
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}

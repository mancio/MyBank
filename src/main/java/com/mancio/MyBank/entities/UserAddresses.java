package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "useraddresses")
public class UserAddresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uaddressid", updatable = false, nullable = false, columnDefinition = "BIGINT(20)")
    private long uadid;
    @Column(name = "street", nullable = false, columnDefinition = "VARCHAR(50)")
    private String street;
    @Column(name = "city", nullable = false, columnDefinition = "VARCHAR(50)")
    private String city;
    @Column(name = "zip", nullable = false, columnDefinition = "VARCHAR(50)")
    private String zip;
    @Column(name = "region", nullable = false, columnDefinition = "VARCHAR(50)")
    private String region;
    @Column(name = "country", nullable = false, columnDefinition = "VARCHAR(50)")
    private String country;

    @OneToMany(mappedBy = "useraddresses")
    private Set<User> user;

    public long getUadid() {
        return uadid;
    }

    public void setUadid(long uadid) {
        this.uadid = uadid;
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}

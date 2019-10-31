package com.mancio.MyBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mancio.MyBank.entities.Security.Authority;
import com.mancio.MyBank.entities.Security.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false, updatable = false)
    private long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String pass;
    @Column(name = "accessstatuscode", nullable = false)
    private int acstcode;
    @Column(name = "name", nullable = false, updatable = false) // visit the bank
    private String name;
    @Column(name = "middlename", updatable = false)
    private String m_name;
    @Column(name = "lastName", nullable = false, updatable = false) // visit the bank
    private String surname;
    @Column(name = "phoneprefix")
    private int phprex;
    @Column(name = "phone")
    private int phone;
    @Column(name = "mail", nullable = false, unique = true)
    private String mail;
    @Column(name = "uaddressid", nullable = false, unique = true)
    private int uaddress;
    @Column(name = "branchid", nullable = false, unique = true)
    private int branchid;

    @OneToMany(mappedBy = "user")
    private Set<BankAccount> bkaccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uaddressid", insertable = false, updatable = false)
    private UserAddresses useraddresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchid", insertable = false, updatable = false)
    private Branches branches;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    public int getAcstcode() {
        return acstcode;
    }

    public void setAcstcode(int acstcode) {
        this.acstcode = acstcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhprex() {
        return phprex;
    }

    public void setPhprex(int phprex) {
        this.phprex = phprex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getUaddress() {
        return uaddress;
    }

    public void setUaddress(int uaddress) {
        this.uaddress = uaddress;
    }

    public int getBranchid() {
        return branchid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public Set<BankAccount> getBkaccount() {
        return bkaccount;
    }

    public void setBkaccount(Set<BankAccount> bkaccount) {
        this.bkaccount = bkaccount;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserAddresses getUseraddresses() {
        return useraddresses;
    }

    public void setUseraddresses(UserAddresses useraddresses) {
        this.useraddresses = useraddresses;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Branches getBranches() {
        return branches;
    }

    public void setBranches(Branches branches) {
        this.branches = branches;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

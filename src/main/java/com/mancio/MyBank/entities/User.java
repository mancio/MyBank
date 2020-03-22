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
    @Column(name = "userid", nullable = false, updatable = false, columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "username", nullable = false, unique = true, columnDefinition = "VARCHAR(30)")
    private String username;
    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(100)")
    private String pass;
    @Column(name = "accessstatuscode", nullable = false, columnDefinition = "INT(10)")
    private int acstcode;
    @Column(name = "name", nullable = false, updatable = false) // visit the bank
    private String name;
    @Column(name = "middlename", updatable = false, columnDefinition = "VARCHAR(30)")
    private String midname;
    @Column(name = "lastname", nullable = false, updatable = false, columnDefinition = "VARCHAR(30)") // visit the bank
    private String surname;
    @Column(name = "phoneprefix", columnDefinition = "INT(10)")
    private String phprex;
    @Column(name = "phone", columnDefinition = "INT(20)")
    private String phone;
    @Column(name = "mail", nullable = false, unique = true, columnDefinition = "VARCHAR(30)")
    private String mail;
    @Column(name = "uaddressid", nullable = false, unique = true, columnDefinition = "BIGINT(20)")
    private long uaddress;
    @Column(name = "branchid", nullable = false, unique = true, columnDefinition = "BIGINT(20)")
    private long branchid;

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

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhprex() {
        return phprex;
    }

    public void setPhprex(String phprex) {
        this.phprex = phprex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getUaddress() {
        return uaddress;
    }

    public void setUaddress(int uaddress) {
        this.uaddress = uaddress;
    }

    public long getBranchid() {
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

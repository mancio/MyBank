package com.mancio.MyBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "user_ID", nullable = false, updatable = false)
    private long id;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "password", nullable = false)
    private String pass;
    @Column(name = "access_status_code", nullable = false)
    private int ac_st_code;
    @Column(name = "name", nullable = false, updatable = false) // visit the bank
    private String name;
    @Column(name = "middle_name", updatable = false)
    private String m_name;
    @Column(name = "last_Name", nullable = false, updatable = false) // visit the bank
    private String surname;
    @Column(name = "phone_prefix")
    private int ph_prex;
    @Column(name = "phone")
    private int phone;
    @Column(name = "mail", nullable = false, unique = true)
    private String mail;
    @Column(name = "u_address_ID", nullable = false, unique = true)
    private int u_address;
    @Column(name = "branch_ID", nullable = false, unique = true)
    private int branch_id;

    @OneToMany(mappedBy = "user")
    private Set<Bank_Account> bkaccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAc_st_code() {
        return ac_st_code;
    }

    public void setAc_st_code(int ac_st_code) {
        this.ac_st_code = ac_st_code;
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

    public int getPh_prex() {
        return ph_prex;
    }

    public void setPh_prex(int ph_prex) {
        this.ph_prex = ph_prex;
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

    public int getU_address() {
        return u_address;
    }

    public void setU_address(int u_address) {
        this.u_address = u_address;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public Set<Bank_Account> getBkaccount() {
        return bkaccount;
    }

    public void setBkaccount(Set<Bank_Account> bkaccount) {
        this.bkaccount = bkaccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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

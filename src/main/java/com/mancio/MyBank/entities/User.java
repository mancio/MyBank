package com.mancio.MyBank.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
@Table(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_ID")
    private long id;
    @Column(name = "Nickname")
    private String nickname;
    @Column(name = "Password")
    private String pass;
    @Column(name = "Access_Status_Code")
    private int ac_st_code;
    @Column(name = "Name")
    private String name;
    @Column(name = "Middle_Name")
    private String m_name;
    @Column(name = "Last_Name")
    private String surname;
    @Column(name = "Phone_Prefix")
    private int ph_prex;
    @Column(name = "Phone")
    private int phone;
    @Column(name = "Mail")
    private String mail;
    @Column(name = "U_Address_ID")
    private int u_address;
    @Column(name = "Branch_ID")
    private int branch_id;

    @OneToMany(mappedBy = "User")
    private Set<Bank_Account> bkaccount;

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

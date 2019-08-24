package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "User")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_ID")
    private long id;
    @Column(name = "Nickname")
    private String nickname;
    @Column(name = "Password")
    private String pass;
    @Column(name = "Name")
    private String name;
    @Column(name = "Middle_Name")
    private String m_name;
    @Column(name = "Last_Name")
    private String surname;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Mail")
    private String mail;
    @Column(name = "Address_ID")
    private String address;
    @Column(name = "Branch_ID")
    private String branch_id;

}

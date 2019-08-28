package com.mancio.MyBank.entities;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {

    @Column(name = "User_ID")
    private String user_id;
    @Column(name = "Authorities")
    private String auth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

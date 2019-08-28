package com.mancio.MyBank.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Access_Details")
public class Access_Details {

    @Id
    @Column(name = "Access_Status_Code") // 1 = ok, 0 = banned
    private int ac_st_cod;
    @Column(name = "Access_Description")
    private String ac_desc;

    @OneToMany(mappedBy = "Access_Details")
    Set<User> user;

    public int getAc_st_cod() {
        return ac_st_cod;
    }

    public void setAc_st_cod(int ac_st_cod) {
        this.ac_st_cod = ac_st_cod;
    }

    public String getAc_desc() {
        return ac_desc;
    }

    public void setAc_desc(String ac_desc) {
        this.ac_desc = ac_desc;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}

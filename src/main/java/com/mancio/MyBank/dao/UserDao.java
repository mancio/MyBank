package com.mancio.MyBank.dao;

import com.mancio.MyBank.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    User findByMail(String mail);
}

package com.mancio.MyBank.dao;

import com.mancio.MyBank.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface User_dao extends CrudRepository<User,Long> {
    User findByUsername(String username);
}

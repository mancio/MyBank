package com.mancio.MyBank.repositories;

import com.mancio.MyBank.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRep extends CrudRepository<User,Long> {};

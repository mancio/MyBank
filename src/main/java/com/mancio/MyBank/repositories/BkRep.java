package com.mancio.MyBank.repositories;

import com.mancio.MyBank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BkRep extends JpaRepository<User,Long> {};

package com.mancio.MyBank.repositories;

import com.mancio.MyBank.entities.BkAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<BkAccount,Long> {};

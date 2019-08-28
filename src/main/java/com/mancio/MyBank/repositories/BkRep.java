package com.mancio.MyBank.repositories;

import com.mancio.MyBank.entities.Bank_Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BkRep extends JpaRepository<Bank_Account,Long> {
    Page<Bank_Account> findByCustomerId(Long customerId, Pageable pageable);
}

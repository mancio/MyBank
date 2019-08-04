package com.mancio.MyBank.repositories;

import com.mancio.MyBank.entities.BkAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BkRep extends JpaRepository<BkAccount,Long> {
    Page<BkAccount> findByCustomerId(Long customerId, Pageable pageable);
}

package com.mancio.MyBank.dao;

import com.mancio.MyBank.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankAccountDao extends CrudRepository<BankAccount,Long> {
    BankAccount findByUser_Id(Long userId);
}

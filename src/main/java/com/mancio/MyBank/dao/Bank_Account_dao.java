package com.mancio.MyBank.dao;

import com.mancio.MyBank.entities.Bank_Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Bank_Account_dao extends CrudRepository<Bank_Account,Long> {
    Bank_Account findByUser_Id(Long userId);
}

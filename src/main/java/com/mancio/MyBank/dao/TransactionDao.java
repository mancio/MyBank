package com.mancio.MyBank.dao;

import com.mancio.MyBank.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDao extends CrudRepository<Transaction,Long> {
    List<Transaction> FindAll();
}

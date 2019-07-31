package com.mancio.MyBank.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountRep extends CrudRepository<Account,Long>{};

package com.example.transferrequest;

import org.springframework.data.repository.CrudRepository;

import com.example.transferrequest.Transactions;

public interface TransactionsRepository extends CrudRepository<Transactions, Long> {

}
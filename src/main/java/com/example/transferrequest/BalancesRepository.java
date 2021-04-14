package com.example.transferrequest;

import org.springframework.data.repository.CrudRepository;

import com.example.transferrequest.Balances;

public interface BalancesRepository extends CrudRepository<Balances, Long> {
    
    public Balances findByAccountNumber(String accountNumber);
}
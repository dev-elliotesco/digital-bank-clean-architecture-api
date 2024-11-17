package com.elliotesco.repositories.transaction;

import com.elliotesco.entities.transaction.TransactionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ITransactionRepository extends ReactiveCrudRepository<TransactionEntity, String> {
}

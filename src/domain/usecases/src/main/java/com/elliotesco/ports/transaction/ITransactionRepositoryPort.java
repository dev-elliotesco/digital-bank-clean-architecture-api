package com.elliotesco.ports.transaction;

import com.elliotesco.entities.Transaction;
import reactor.core.publisher.Mono;

public interface ITransactionRepositoryPort {
    Mono<Transaction> save(Transaction transaction);
}

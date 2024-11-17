package com.elliotesco.adapters.transaction;

import com.elliotesco.entities.Transaction;
import com.elliotesco.mappers.transaction.TransactionMapper;
import com.elliotesco.ports.transaction.ITransactionRepositoryPort;
import com.elliotesco.repositories.transaction.ITransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements ITransactionRepositoryPort {

    private final ITransactionRepository transactionRepository;

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        return transactionRepository.save(TransactionMapper.toEntity(transaction))
                .map(TransactionMapper::toModel);
    }
}

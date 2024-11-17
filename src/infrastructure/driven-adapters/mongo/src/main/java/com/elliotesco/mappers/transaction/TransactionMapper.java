package com.elliotesco.mappers.transaction;

import com.elliotesco.entities.Transaction;
import com.elliotesco.entities.transaction.TransactionEntity;

public class TransactionMapper {
    public static TransactionEntity toEntity(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return new TransactionEntity(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount()
        );
    }

    public static Transaction toModel(TransactionEntity transactionEntity) {
        if (transactionEntity == null) {
            return null;
        }
        return new Transaction(
                transactionEntity.getId(),
                transactionEntity.getType(),
                transactionEntity.getAmount()
        );
    }
}

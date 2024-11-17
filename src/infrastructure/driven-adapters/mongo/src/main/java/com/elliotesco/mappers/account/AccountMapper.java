package com.elliotesco.mappers.account;

import com.elliotesco.entities.Account;
import com.elliotesco.entities.account.AccountEntity;
import com.elliotesco.entities.Transaction;
import com.elliotesco.entities.transaction.TransactionEntity;
import com.elliotesco.mappers.transaction.TransactionMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {
    public static AccountEntity toEntity(Account account) {
        if (account == null) {
            return null;
        }
        List<TransactionEntity> transactionEntities = account.getTransactions() != null ?
                account.getTransactions().stream()
                        .map(TransactionMapper::toEntity)
                        .collect(Collectors.toList()) : null;
        return new AccountEntity(
                account.getId(),
                account.getNumber(),
                account.getType(),
                transactionEntities
        );
    }

    public static Account toModel(AccountEntity accountEntity) {
        if (accountEntity == null) {
            return null;
        }
        List<Transaction> transactions = accountEntity.getTransactions() != null ?
                accountEntity.getTransactions().stream()
                        .map(TransactionMapper::toModel)
                        .collect(Collectors.toList()) : null;
        return new Account(
                accountEntity.getId(),
                accountEntity.getNumber(),
                accountEntity.getType(),
                transactions
        );
    }
}
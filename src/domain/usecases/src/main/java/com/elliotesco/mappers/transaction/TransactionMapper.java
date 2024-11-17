package com.elliotesco.mappers.transaction;

import com.elliotesco.dtos.transaction.TransactionRequestDTO;
import com.elliotesco.dtos.transaction.TransactionResponseDTO;
import com.elliotesco.dtos.transaction.TransactionSummaryDTO;
import com.elliotesco.entities.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    public Transaction toTransaction(TransactionRequestDTO request) {
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        return transaction;
    }

    public TransactionResponseDTO toTransactionResponseDTO(Transaction transaction, String accountId) {
        TransactionResponseDTO response = new TransactionResponseDTO();
        response.setId(transaction.getId());
        response.setAmount(transaction.getAmount());
        response.setType(transaction.getType());
        response.setTimestamp(LocalDateTime.now());
        response.setAccountId(accountId);
        return response;
    }

    public TransactionSummaryDTO toTransactionSummaryDTO(Transaction transaction) {
        TransactionSummaryDTO summary = new TransactionSummaryDTO();
        summary.setId(transaction.getId());
        summary.setType(transaction.getType());
        summary.setAmount(transaction.getAmount());
        return summary;
    }
}

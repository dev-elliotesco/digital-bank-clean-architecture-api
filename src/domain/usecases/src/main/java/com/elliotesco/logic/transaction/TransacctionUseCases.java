package com.elliotesco.logic.transaction;

import com.elliotesco.dtos.transaction.TransactionRequestDTO;
import com.elliotesco.dtos.transaction.TransactionResponseDTO;
import com.elliotesco.entities.Transaction;
import com.elliotesco.exceptions.transaction.InsufficientFundsException;
import com.elliotesco.logic.account.AccountUseCases;
import com.elliotesco.mappers.transaction.TransactionMapper;
import com.elliotesco.ports.account.IAccountRepositoryPort;
import com.elliotesco.ports.transaction.ITransactionRepositoryPort;
import com.elliotesco.utils.ErrorMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TransacctionUseCases {

    private final ITransactionRepositoryPort transactionRepositoryPort;
    private final IAccountRepositoryPort accountRepositoryPort;
    private final TransactionMapper transactionMapper;
    private final AccountUseCases accountUseCases;

    public Mono<TransactionResponseDTO> makeTransaction(String accountNumber, TransactionRequestDTO request) {
        return accountUseCases.checkAccountExists(accountNumber)
                .then(accountRepositoryPort.findByNumber(accountNumber)
                        .flatMap(account -> {

                            return accountUseCases.getBalance(accountNumber)
                                    .flatMap(totalBalance -> {
                                        if ("RETIRO".equals(request.getType()) && request.getAmount() > totalBalance) {
                                            return Mono.error(new InsufficientFundsException(ErrorMessages.INSUFFICIENT_FUNDS));
                                        }

                                        Transaction transaction = transactionMapper.toTransaction(request);

                                        return transactionRepositoryPort.save(transaction)
                                                .flatMap(savedTransaction -> {
                                                    account.getTransactions().add(savedTransaction);

                                                    return accountRepositoryPort.save(account)
                                                            .thenReturn(transactionMapper.toTransactionResponseDTO(savedTransaction, accountNumber));
                                                });
                                    });
                        })
                );
    }
}

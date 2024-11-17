package com.elliotesco.logic.account;

import com.elliotesco.dtos.account.AccountRequestDTO;
import com.elliotesco.dtos.account.AccountResponseDTO;
import com.elliotesco.dtos.transaction.TransactionResponseDTO;
import com.elliotesco.dtos.transaction.TransactionSummaryDTO;
import com.elliotesco.entities.Account;
import com.elliotesco.entities.User;
import com.elliotesco.exceptions.account.AccountAlreadyExistsException;
import com.elliotesco.exceptions.account.AccountNotFoundException;
import com.elliotesco.exceptions.user.UserNotFoundException;
import com.elliotesco.mappers.account.AccountMapper;
import com.elliotesco.mappers.transaction.TransactionMapper;
import com.elliotesco.ports.account.IAccountRepositoryPort;
import com.elliotesco.ports.user.IUserRepositoryPort;
import com.elliotesco.utils.ErrorMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountUseCases {

    private final IAccountRepositoryPort accountRepositoryPort;
    private final IUserRepositoryPort userRepositoryPort;
    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;

    public Mono<AccountResponseDTO> createAccount(String userId, AccountRequestDTO accountRequest) {
        return validateUser(userId)
                .flatMap(user -> validateAccountNumber(accountRequest.getNumber())
                        .then(saveAccount(user, accountRequest))
                );
    }

    public Mono<Double> getBalance(String accountNumber) {
        return checkAccountExists(accountNumber)
                .flatMap(account -> {
                    double totalBalance = account.getTransactions().stream()
                            .mapToDouble(transaction ->
                                    "DEPOSITO".equals(transaction.getType()) ? transaction.getAmount() : -transaction.getAmount())
                            .sum();
                    return Mono.just(totalBalance);
                });
    }

    public Mono<List<TransactionResponseDTO>> getWithdrawals(String accountNumber) {
        return checkAccountExists(accountNumber)
                .flatMap(account -> {
                    List<TransactionResponseDTO> withdrawals = account.getTransactions().stream()
                            .filter(transaction -> "RETIRO".equals(transaction.getType()))
                            .map(transaction -> transactionMapper.toTransactionResponseDTO(transaction, accountNumber))
                            .collect(Collectors.toList());
                    return Mono.just(withdrawals);
                });
    }

    public Mono<List<TransactionResponseDTO>> getDeposits(String accountNumber) {
        return checkAccountExists(accountNumber)
                .flatMap(account -> {
                    List<TransactionResponseDTO> deposits = account.getTransactions().stream()
                            .filter(transaction -> "DEPOSITO".equals(transaction.getType()))
                            .map(transaction -> transactionMapper.toTransactionResponseDTO(transaction, accountNumber))
                            .collect(Collectors.toList());
                    return Mono.just(deposits);
                });
    }

    public Mono<List<TransactionSummaryDTO>> getTransactionSummary(String accountNumber) {
        return checkAccountExists(accountNumber)
                .flatMap(account -> {
                    List<TransactionSummaryDTO> transactionsSummary = account.getTransactions().stream()
                            .map(transactionMapper::toTransactionSummaryDTO)
                            .collect(Collectors.toList());
                    return Mono.just(transactionsSummary);
                });
    }

    public Mono<User> validateUser(String userId) {
        return userRepositoryPort.findById(userId)
                .switchIfEmpty(Mono.error(new UserNotFoundException(ErrorMessages.USER_NOT_FOUND + userId)));
    }

    public Mono<Void> validateAccountNumber(String accountNumber) {
        return accountRepositoryPort.findByNumber(accountNumber)
                .flatMap(existingAccount ->
                        Mono.error(new AccountAlreadyExistsException(ErrorMessages.ACCOUNT_ALREADY_EXISTS + accountNumber))
                )
                .then();
    }

    public Mono<Account> checkAccountExists(String accountNumber) {
        return accountRepositoryPort.findByNumber(accountNumber)
                .switchIfEmpty(Mono.error(new AccountNotFoundException(ErrorMessages.ACCOUNT_NOT_FOUND + accountNumber)));
    }

    public Mono<AccountResponseDTO> saveAccount(User user, AccountRequestDTO accountRequest) {
        Account account = accountMapper.toAccount(accountRequest);

        if (user.getAccounts() == null) {
            user.setAccounts(new ArrayList<>());
        }
        user.getAccounts().add(account);

        return userRepositoryPort.save(user)
                .then(accountRepositoryPort.save(account))
                .map(accountMapper::toAccountResponseDTO);
    }
}

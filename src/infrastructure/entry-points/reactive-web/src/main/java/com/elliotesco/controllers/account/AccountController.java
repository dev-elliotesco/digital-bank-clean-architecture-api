package com.elliotesco.controllers.account;

import com.elliotesco.dtos.account.AccountRequestDTO;
import com.elliotesco.dtos.account.AccountResponseDTO;
import com.elliotesco.dtos.transaction.TransactionResponseDTO;
import com.elliotesco.dtos.transaction.TransactionSummaryDTO;
import com.elliotesco.logic.account.AccountUseCases;
import com.elliotesco.mappers.account.AccountMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController implements AccountControllerDOC {

    private final AccountUseCases accountUseCases;
    private final AccountMapper accountMapper;

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AccountResponseDTO> createAccount(@PathVariable String userId, @Valid @RequestBody AccountRequestDTO accountRequest) {
        return accountUseCases.createAccount(userId, accountRequest);
    }

    @GetMapping("/balance/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Double> getBalance(@PathVariable String accountNumber) {
        return accountUseCases.getBalance(accountNumber);
    }

    @GetMapping("/withdrawals/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<List<TransactionResponseDTO>> getWithdrawals(@PathVariable String accountNumber) {
        return accountUseCases.getWithdrawals(accountNumber);
    }

    @GetMapping("/deposits/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<List<TransactionResponseDTO>> getDeposits(@PathVariable String accountNumber) {
        return accountUseCases.getDeposits(accountNumber);
    }

    @GetMapping("/transactions/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<List<TransactionSummaryDTO>> getTransactionSummary(@PathVariable String accountNumber) {
        return accountUseCases.getTransactionSummary(accountNumber);
    }
}

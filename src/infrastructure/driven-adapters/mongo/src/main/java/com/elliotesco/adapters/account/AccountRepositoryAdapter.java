package com.elliotesco.adapters.account;

import com.elliotesco.entities.Account;
import com.elliotesco.mappers.account.AccountMapper;
import com.elliotesco.ports.account.IAccountRepositoryPort;
import com.elliotesco.repositories.account.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements IAccountRepositoryPort {

    private final IAccountRepository accountRepository;

    @Override
    public Mono<Account> save(Account account) {
        return accountRepository.save(AccountMapper.toEntity(account))
                .map(AccountMapper::toModel);
    }

    @Override
    public Mono<Account> findByNumber(String number) {
        return accountRepository.findByNumber(number)
                .map(AccountMapper::toModel);
    }
}

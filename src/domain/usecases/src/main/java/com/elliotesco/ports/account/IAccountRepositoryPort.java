package com.elliotesco.ports.account;

import com.elliotesco.entities.Account;
import reactor.core.publisher.Mono;

public interface IAccountRepositoryPort {
    Mono<Account> save(Account account);
    Mono<Account> findByNumber(String number);
}

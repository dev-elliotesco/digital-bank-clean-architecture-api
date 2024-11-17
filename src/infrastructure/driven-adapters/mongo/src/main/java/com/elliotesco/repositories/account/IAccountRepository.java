package com.elliotesco.repositories.account;

import com.elliotesco.entities.account.AccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IAccountRepository extends ReactiveCrudRepository<AccountEntity, Integer> {
    Mono<AccountEntity> findByNumber(String number);
}

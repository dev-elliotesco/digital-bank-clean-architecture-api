package com.elliotesco.mappers.account;

import com.elliotesco.dtos.account.AccountRequestDTO;
import com.elliotesco.dtos.account.AccountResponseDTO;
import com.elliotesco.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toAccount(AccountRequestDTO accountRequest) {
        Account account = new Account();
        account.setNumber(accountRequest.getNumber());
        account.setType(accountRequest.getType());
        return account;
    }

    public AccountResponseDTO toAccountResponseDTO(Account account) {
        AccountResponseDTO response = new AccountResponseDTO();
        response.setId(account.getId());
        response.setNumber(account.getNumber());
        response.setType(account.getType());
        return response;
    }
}
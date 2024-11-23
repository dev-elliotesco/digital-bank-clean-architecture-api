package com.elliotesco.controllers.transaction;

import com.elliotesco.dtos.transaction.TransactionRequestDTO;
import com.elliotesco.dtos.transaction.TransactionResponseDTO;
import com.elliotesco.dtos.transaction.TransferRequestDTO;
import com.elliotesco.logic.transaction.TransacctionUseCases;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController implements TransactionControllerDOC {

    private final TransacctionUseCases transacctionUseCases;

    @PostMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TransactionResponseDTO> makeTransaction(@PathVariable String accountNumber, @Valid @RequestBody TransactionRequestDTO transactionRequest) {
        return transacctionUseCases.makeTransaction(accountNumber, transactionRequest);
    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> transferFunds(@Valid @RequestBody TransferRequestDTO transferRequest) {
        return transacctionUseCases.transferFunds(transferRequest);
    }
}

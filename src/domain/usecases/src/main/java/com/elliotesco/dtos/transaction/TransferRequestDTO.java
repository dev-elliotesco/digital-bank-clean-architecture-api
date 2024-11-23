package com.elliotesco.dtos.transaction;

import com.elliotesco.utils.ErrorMessages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDTO {

    @NotNull(message = ErrorMessages.ACCOUNT_NUMBER_NOT_EMPTY)
    private String fromAccountNumber;

    @NotNull(message = ErrorMessages.ACCOUNT_NUMBER_NOT_EMPTY)
    private String toAccountNumber;

    @NotNull(message = ErrorMessages.TRANSACTION_AMOUNT_NOT_EMPTY)
    @Min(value = 0, message = ErrorMessages.TRANSACTION_AMOUNT_NOT_VALID)
    private double amount;
}

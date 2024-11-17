package com.elliotesco.dtos.account;

import com.elliotesco.utils.ErrorMessages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {
    @NotEmpty(message = ErrorMessages.ACCOUNT_NUMBER_NOT_EMPTY)
    private String number;

    @NotEmpty(message = ErrorMessages.ACCOUNT_TYPE_NOT_EMPTY)
    @Pattern(regexp = ErrorMessages.ACCOUNT_TYPE, message = ErrorMessages.ACCOUNT_TYPE_NOT_VALID)
    private String type;
}

package com.elliotesco.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionSummaryDTO {
    private String id;
    private String type;
    private double amount;
}

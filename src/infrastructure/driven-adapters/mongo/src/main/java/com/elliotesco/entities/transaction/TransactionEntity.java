package com.elliotesco.entities.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Transactions")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    private String id;
    private String type;
    private double amount;
}

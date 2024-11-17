package com.elliotesco.entities.account;

import com.elliotesco.entities.transaction.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Accounts")
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    @Id
    private String id;
    private String number;
    private String type;
    private List<TransactionEntity> transactions = new ArrayList<>();
}

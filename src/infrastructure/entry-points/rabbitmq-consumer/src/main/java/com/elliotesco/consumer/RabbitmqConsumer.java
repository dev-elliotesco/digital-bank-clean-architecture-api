package com.elliotesco.consumer;

import com.elliotesco.dtos.transaction.TransactionRequestDTO;
import com.elliotesco.dtos.transaction.TransferRequestDTO;
import com.elliotesco.logic.transaction.TransacctionUseCases;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RabbitmqConsumer {

    private final TransacctionUseCases transacctionUseCases;

    public RabbitmqConsumer(TransacctionUseCases transacctionUseCases) {
        this.transacctionUseCases = transacctionUseCases;
    }

    @RabbitListener(queues = "${rabbit.queue-name}")
    public void handleTransaction(TransferRequestDTO transferRequest) {
        Mono<Void> result = transacctionUseCases.transferFunds(transferRequest);
        result.subscribe();
        System.out.println("Received transaction: " + transferRequest);
    }
}

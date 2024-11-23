package com.elliotesco.ports.broker;

public interface IMessageBrokerPort {
    void send(Object payload);
}

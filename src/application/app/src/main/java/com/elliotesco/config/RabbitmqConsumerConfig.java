package com.elliotesco.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.elliotesco.consumer")
public class RabbitmqConsumerConfig {
}

package com.elliotesco.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@ComponentScan(basePackages = "com.elliotesco.adapters")
@EnableReactiveMongoRepositories(basePackages = "com.elliotesco.repositories")
@EntityScan(basePackages = "com.elliotesco.entities")
public class MongoConfig {
}

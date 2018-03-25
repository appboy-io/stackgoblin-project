package com.stackgoblin.stackgoblin.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class DatabaseConfig extends AbstractReactiveMongoConfiguration {

    private Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Value("${spring.data.mongodb.name}")
    private String dbName;


    @Override
    protected String getDatabaseName() {
        logger.info("Starting db with name: {}", dbName);
        return dbName;
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
}

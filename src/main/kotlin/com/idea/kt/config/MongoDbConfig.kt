package com.idea.kt.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoDbConfig {

    @Bean
    fun mongoClient():MongoClient{
        return MongoClients.create("mongodb://localhost:27017")
    }

    @Bean
    fun getDatabaseName():String{
        return "UserSystem"
    }

}
package com.idea.kt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class KtApplication

fun main(args: Array<String>) {
	runApplication<KtApplication>(*args)
}

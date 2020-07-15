package com.idea.kt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = arrayOf(MongoAutoConfiguration::class,MongoDataAutoConfiguration::class))
class KtApplication

fun main(args: Array<String>) {
	runApplication<KtApplication>(*args)
}

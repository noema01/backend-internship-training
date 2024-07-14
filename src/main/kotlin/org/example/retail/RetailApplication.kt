package org.example.retail

import org.example.retail.properties.ApplicationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties::class)
class RetailApplication

fun main(args: Array<String>) {
	runApplication<RetailApplication>(*args)
}

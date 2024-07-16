package net.noema.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableConfigurationProperties(ApplicationProperties::class)
class GraphQlApplication

fun main(args: Array<String>) {
	runApplication<GraphQlApplication>(*args)
}

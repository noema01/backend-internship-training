package net.noema.inventory

import net.noema.inventory.properties.ApplicationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties::class)
class PaymentApplication

fun main(args: Array<String>) {
	runApplication<PaymentApplication>(*args)
}

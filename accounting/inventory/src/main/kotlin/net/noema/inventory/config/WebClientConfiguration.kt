package net.noema.inventory.config

import net.noema.inventory.properties.ApplicationProperties
import net.noema.inventory.clients.WebClientWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebClientConfiguration {

    @Bean
    suspend fun webClient(@Autowired appProperties: ApplicationProperties): WebClientWrapper {
        return WebClientWrapper(baseUrl = appProperties.shippingGatewayBaseUrl)
    }
}
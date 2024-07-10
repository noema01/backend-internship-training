package org.example.retail.config

import org.example.retail.ApplicationProperties
import org.example.retail.clients.WebClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebClientConfiguration {

    @Bean
    suspend fun webClient(@Autowired appProperties: ApplicationProperties): WebClient {
        return WebClient(baseUrl = appProperties.shippingGatewayBaseUrl)
    }
}
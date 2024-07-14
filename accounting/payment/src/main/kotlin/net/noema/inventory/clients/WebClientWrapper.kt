package net.noema.inventory.clients

import org.springframework.web.reactive.function.client.WebClient
import org.example.retail.shipping.ShipmentEntity
import org.springframework.web.reactive.function.client.awaitBody

class WebClientWrapper(baseUrl: String) {

    private val webClient: WebClient = WebClient.builder()
        .baseUrl(baseUrl)
        .build()

    suspend fun getSomething(endpoint: String): String {
        return webClient.get()
            .uri(endpoint)
            .retrieve()
            .awaitBody()
    }

    suspend fun postSomething(endpoint: String, body: Any): ShipmentEntity {
        return webClient.post()
            .uri(endpoint)
            .bodyValue(body)
            .retrieve()
            .awaitBody()
    }

}

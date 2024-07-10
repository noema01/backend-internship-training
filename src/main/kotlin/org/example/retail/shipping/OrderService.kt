package org.example.retail.shipping

import org.example.retail.clients.WebClient
import org.springframework.stereotype.Service


@Service
class OrderService (private val webClient: WebClient) {
    suspend fun createShipment(order: Order): ShipmentEntity {
        return webClient.postSomething("/create-shipment", order)
    }
}
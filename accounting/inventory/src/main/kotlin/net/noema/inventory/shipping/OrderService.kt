package org.example.retail.shipping

import net.noema.inventory.clients.WebClientWrapper
import org.springframework.stereotype.Service


@Service
class OrderService (private val webClient: WebClientWrapper) {
    suspend fun createShipment(order: Order): ShipmentEntity {
        return webClient.postSomething("/create-shipment", order)
    }
}
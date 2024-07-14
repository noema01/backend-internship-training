package org.example.retail.shipping

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController (private val orderService: OrderService){

    @PostMapping("orders")
    suspend fun createShipment(@RequestBody order: Order): ShipmentEntity {
        return orderService.createShipment(order)
    }
}
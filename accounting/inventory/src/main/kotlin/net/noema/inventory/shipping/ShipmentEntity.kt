package org.example.retail.shipping


data class ShipmentEntity (
    val orderId: String,
    val trackingNumber: String,
    val shippingProvider: String
)
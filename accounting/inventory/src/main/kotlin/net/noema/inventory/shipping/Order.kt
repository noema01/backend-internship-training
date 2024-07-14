package org.example.retail.shipping

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Order(
    @Id
    val id: String? = null,
    val productId: String,
    val quantity: Int,
    val customerId: String,
    val shippingAddress: String
)
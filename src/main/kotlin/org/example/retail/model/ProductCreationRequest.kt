package org.example.retail.model

import org.springframework.data.mongodb.core.mapping.MongoId

data class ProductCreationRequest(
    val name: String,
    val price: Double,
    val vendorId: String
)
package org.example.retail.model

import org.example.retail.entity.ProductEntity
import org.example.retail.exceptions.NotFoundException
import org.springframework.data.mongodb.core.mapping.MongoId

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val vendorId: String
)

data class ProductMutation(
    val name: String,
    val price: Double,
    val vendorId: String,
)
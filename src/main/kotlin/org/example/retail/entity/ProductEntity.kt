package org.example.retail.entity

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="products")
data class ProductEntity (
    val id: String?= null,
    val name: String,
    val price: Double,
    @Indexed
    val vendorId: String
)
package org.example.retail.extensions

import org.example.retail.entity.ProductEntity
import org.example.retail.exceptions.NotFoundException
import org.example.retail.model.Product
import org.example.retail.model.ProductMutation

fun ProductEntity.toDto(): Product {
    return Product(
        id = this.id ?: throw NotFoundException("Product ID not found!"),
        name = this.name,
        vendorId = this.vendorId,
        price = this.price
    )
}

fun ProductMutation.toNewEntity(): ProductEntity {
    return ProductEntity(
        name = this.name,
        vendorId = this.vendorId,
        price = this.price
    )
}
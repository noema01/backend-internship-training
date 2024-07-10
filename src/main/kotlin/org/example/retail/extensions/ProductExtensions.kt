package org.example.retail.extensions

import org.example.retail.entity.ProductEntity
import org.example.retail.exceptions.NotFoundException
import org.example.retail.model.Product

class ProductExtensions {
    companion object {
        fun ProductEntity.toDto(): Product {
            return Product(
                id = this.id ?: throw NotFoundException("Product ID not found!"),
                name = this.name,
                vendorId = this.vendorId,
                price = this.price
            )
        }
    }
}
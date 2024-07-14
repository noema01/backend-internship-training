package net.noema.inventory.extensions

import net.noema.inventory.entity.ProductEntity
import net.noema.inventory.exceptions.NotFoundException
import net.noema.inventory.model.Product
import net.noema.inventory.model.ProductMutation

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
package net.noema.inventory.model


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
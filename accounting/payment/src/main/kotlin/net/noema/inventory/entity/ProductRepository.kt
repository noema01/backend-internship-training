package net.noema.inventory.entity

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: CoroutineCrudRepository<ProductEntity, String>{
    suspend fun findAllByVendorId(vendorId: String) : List<ProductEntity>
}
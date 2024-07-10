package com.noema.retail.services

import com.noema.retail.ProductRepository
import com.noema.retail.authentication.AuthenticationService
import com.noema.retail.dtos.productDto
import com.noema.retail.toDto
import com.noema.retail.toNewEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class ProductServices(
    private val repository: ProductRepository,
    val mongoOperation: ReactiveMongoOperations,

    ) {

    suspend fun findAllProducts(): Flow<productDto> = repository.findAll().map { it.toDto() }
    suspend fun getProductById(id: String): productDto =
        repository.findById(id)?.toDto() ?: throw Exception("product not found")

    suspend fun createProduct(product: productDto) {
        repository.save(product.toNewEntity()).toDto()
    }

    suspend fun updateProduct(id: String, updatedProduct: productDto) {
        val existingProduct = repository.findById(id)?.toDto() ?: throw Exception("product not found")

        val updatedProduct = existingProduct.copy(
            name = updatedProduct.name,
            price = updatedProduct.price,
            vendorId = updatedProduct.vendorId,
        )
        repository.save(updatedProduct.toNewEntity())

    }

    suspend fun deleteProduct(id: String) {
        return repository.deleteById(id);
    }

    suspend fun findAllByVendorId(vendorId: String): List<productDto> {
        val criteria = Criteria().orOperator(
            Criteria.where("vendorId").`is`("vendorId")
        )
        val query = Query(criteria)
        mongoOperation.find(query)
    }

    //repository.findAllByVendorId(vendorId).map { it.toDto() };
}
package org.example.retail.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.example.retail.exceptions.NotFoundException
import org.example.retail.entity.ProductEntity
import org.example.retail.model.ProductCreationRequest
import org.example.retail.entity.ProductRepository
import org.example.retail.entity.VendorRepository
import org.example.retail.extensions.toDto
import org.example.retail.model.Product
import org.springframework.stereotype.Service

@Service

class ProductService(
    val vendorRepository: VendorRepository,
    val productRepository: ProductRepository,
) {

    suspend fun createProduct(request: ProductCreationRequest): Product {

        val newEntity = ProductEntity(
            name = request.name,
            vendorId = request.vendorId,
            price = request.price
        )
        val savedProduct = productRepository.save(newEntity)
        return savedProduct.toDto()
    }

    suspend fun getProductById(id: String): Product {
        val product = productRepository.findById(id) ?: throw NotFoundException("Product $id not found!")
        return product.toDto()
    }

    suspend fun findAllProducts(): Flow<Product> {
        val productEntities = productRepository.findAll()
        return productEntities.map { it.toDto() }
    }

    suspend fun findProductsByVendorId(vendorId: String): List<Product> {
        val vendorExists: Boolean = vendorRepository.existsById(vendorId)
        if (!vendorExists) {
            throw NotFoundException("Vendor with ID $vendorId not found!")
        }
        val productEntities =
            productRepository.findAllByVendorId(vendorId) ?: throw NotFoundException("0 Products from $vendorId found!")
        return productEntities.map { it.toDto() }
    }

    suspend fun updateProduct(id:String, request: ProductCreationRequest):Product{
        val existingProduct = productRepository.findById(id) ?: throw NotFoundException("Product $id not found!")
        val updatedProduct=existingProduct.copy(
            name = request.name,
            vendorId = request.vendorId,
            price = request.price
        )
        productRepository.save(updatedProduct)
        return updatedProduct.toDto()
    }


}

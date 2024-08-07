package net.noema.inventory.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.noema.inventory.exceptions.NotFoundException
import net.noema.inventory.entity.ProductRepository
import net.noema.inventory.entity.VendorRepository
import net.noema.inventory.extensions.toDto
import net.noema.inventory.extensions.toNewEntity
import net.noema.inventory.model.Product
import net.noema.inventory.model.ProductMutation
import org.springframework.stereotype.Service

@Service

class ProductService(
    val vendorRepository: VendorRepository,
    val productRepository: ProductRepository,
) {

    suspend fun createProduct(request: ProductMutation): Product {
        val savedProduct = productRepository.save(request.toNewEntity())
        return savedProduct.toDto()

        /*Note to ask about --> if this code throws an exception is it going to be stored in the val then returned to the user ?
        return productRepository.save(request.toNewEntity()).toDto()
         */
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

    suspend fun updateProduct(id: String, request: ProductMutation): Product {
        val existingProduct = productRepository.findById(id) ?: throw NotFoundException("Product $id not found!")
        val updatedProduct = existingProduct.copy(
            name = request.name,
            vendorId = request.vendorId,
            price = request.price
        )
        productRepository.save(updatedProduct)
        return updatedProduct.toDto()
    }


}

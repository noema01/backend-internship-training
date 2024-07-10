package org.example.retail.rest

import kotlinx.coroutines.flow.Flow
import org.example.retail.entity.ProductEntity
import org.example.retail.model.Product
import org.example.retail.model.ProductCreationRequest
import org.example.retail.product.ProductService
import org.example.retail.rest.ProductController.Companion.BASE_URL
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(BASE_URL)
class ProductController(
    private val productService: ProductService
) {
    companion object {
        const val BASE_URL = "/products"
    }

    @PostMapping
    suspend fun createProduct(
        @RequestBody request: ProductCreationRequest
    ): Product {
        return productService.createProduct(request)
    }

    @GetMapping("/{id}")
    suspend fun getProductById(@PathVariable("id") id: String): Product = productService.getProductById(id)


    @GetMapping
    suspend fun findProductsByVendorId(@RequestParam("vendorId") vendorId: String): List<Product> = productService.findProductsByVendorId(vendorId)

    @PutMapping("/{id}")
    suspend fun updateProduct(@PathVariable("id") id: String, @RequestBody newProduct: ProductCreationRequest):Product = productService.updateProduct(id, newProduct)
}


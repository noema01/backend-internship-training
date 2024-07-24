package net.noema.inventory

import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import net.noema.inventory.entity.ProductEntity
import net.noema.inventory.entity.ProductRepository
import net.noema.inventory.entity.VendorRepository
import net.noema.inventory.product.ProductService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@ExtendWith(MockKExtension::class)
class ProductServiceTests {

    @MockK
    private lateinit var vendorRepository: VendorRepository

    @MockK
    private lateinit var productRepository: ProductRepository

    @InjectMockKs
    private lateinit var productService: ProductService


    @Test
    fun `this will test getProductById to return a value`(): Unit = runBlocking {

        val productEntity = ProductEntity(
            name = "Test Product",
            price = 1.0,
            vendorId = "1"
        )

        coEvery { productRepository.findById(any()) } answers {
            if (firstArg<String>() == "1") {
                return@answers ProductEntity(
                    id = "1",
                    name = "First Product",
                    price = 1.0,
                    vendorId = "1"
                )
            }
            productEntity.copy(id = firstArg())
        }

        val result10 = productService.getProductById("10")
        val result1 = productService.getProductById("1")

        assertNotNull(result1)
        assertEquals(result10.id, "10")
        assertEquals(result10.name, "Test Product")
        assertEquals(result1.name, "First Product")

    }

}
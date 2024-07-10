package org.example.retail.rest

import kotlinx.coroutines.flow.Flow
import org.example.retail.model.Vendor
import org.example.retail.model.VendorCreationRequest
import org.example.retail.product.VendorService
import org.example.retail.rest.VendorController.Companion.BASE_URL
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(BASE_URL)
class VendorController (private val vendorService: VendorService) {

    companion object{
        const val BASE_URL = "/vendors"
    }

    @PostMapping
    suspend fun createVendor(
        @RequestBody request: VendorCreationRequest
    ): Vendor {
        return vendorService.createVendor(request)
    }

    @GetMapping("/{id}")
    suspend fun getVendorById(@PathVariable("id") id: String): Vendor = vendorService.getVendorById(id)

    @DeleteMapping("/{id}")
    suspend fun deleteVendorById(@PathVariable("id") id: String) {vendorService.deleteVendorById(id)}

    @GetMapping()
    suspend fun getAllVendors(): Flow<Vendor> = vendorService.getAllVendors()

    @PutMapping("/{id}")
    suspend fun updateVendor(@PathVariable("id") id: String, @RequestBody newVendor: VendorCreationRequest): Vendor = vendorService.updateVendor(id, newVendor)
}
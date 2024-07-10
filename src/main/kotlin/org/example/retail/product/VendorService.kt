package org.example.retail.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.example.retail.entity.VendorEntity
import org.example.retail.entity.VendorRepository
import org.example.retail.exceptions.NotFoundException
import org.example.retail.model.Vendor
import org.example.retail.model.VendorCreationRequest
import org.springframework.stereotype.Service
import org.example.retail.extensions.VendorExtensions.Companion.toDto

@Service
class VendorService(
    val vendorRepository: VendorRepository
) {

    suspend fun createVendor(request: VendorCreationRequest): Vendor {
        val newEntity = VendorEntity(
            name = request.name,
            website = request.website,
            phoneNumber = request.phoneNumber,
            countryCode = request.countryCode
        )
        val savedEntity = vendorRepository.save(newEntity)
        return savedEntity.toDto()
    }

    suspend fun getVendorById(id: String): Vendor {
        val vendor = vendorRepository.findById(id) ?: throw NotFoundException("Vendor $id not found!")
        return vendor.toDto()
    }

    suspend fun getAllVendors(): Flow<Vendor> {
        val vendorEntities = vendorRepository.findAll()
        return vendorEntities.map { it.toDto() }
    }

    suspend fun deleteVendorById(id: String) {
        vendorRepository.deleteById(id)
    }

    suspend fun updateVendor(id:String, request: VendorCreationRequest):Vendor{
        val existingVendor = vendorRepository.findById(id) ?: throw NotFoundException("Vendor $id not found!")
        val updatedVendor= existingVendor.copy(
            name = request.name,
            website = request.website,
            phoneNumber = request.phoneNumber,
            countryCode = request.countryCode
        )
        vendorRepository.save(updatedVendor)
        return updatedVendor.toDto()
    }


}
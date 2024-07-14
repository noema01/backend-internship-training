package org.example.retail.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.example.retail.entity.VendorEntity
import org.example.retail.entity.VendorRepository
import org.example.retail.exceptions.NotFoundException
import org.example.retail.extensions.toDto
import org.example.retail.model.Vendor
import org.example.retail.model.VendorMutation
import org.springframework.stereotype.Service

@Service
class VendorService(
    val vendorRepository: VendorRepository
) {

    suspend fun createVendor(request: VendorMutation): Vendor {
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

    suspend fun getAllVendors(): List<Vendor> {
        val vendorEntities = vendorRepository.findAll().toList()
        return vendorEntities.map { it.toDto() }
    }

    suspend fun deleteVendorById(id: String) {
        vendorRepository.deleteById(id)
    }

    suspend fun updateVendor(id:String, input: VendorMutation):Vendor{
        val existingVendor = vendorRepository.findById(id) ?: throw NotFoundException("Vendor $id not found!")
        val updatedVendor= existingVendor.copy(
            name = input.name,
            website = input.website,
            phoneNumber = input.phoneNumber,
            countryCode = input.countryCode
        )
        vendorRepository.save(updatedVendor)
        return updatedVendor.toDto()
    }


}
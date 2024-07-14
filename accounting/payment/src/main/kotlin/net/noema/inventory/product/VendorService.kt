package net.noema.inventory.product

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import net.noema.inventory.entity.VendorEntity
import net.noema.inventory.entity.VendorRepository
import net.noema.inventory.exceptions.NotFoundException
import net.noema.inventory.extensions.toDto
import net.noema.inventory.model.Vendor
import net.noema.inventory.model.VendorMutation
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

    suspend fun updateVendor(id:String, input: VendorMutation): Vendor {
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
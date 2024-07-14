package net.noema.inventory.entity

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VendorRepository: CoroutineCrudRepository<VendorEntity, String>
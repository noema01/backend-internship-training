package org.example.retail.entity

import org.example.retail.model.Product
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VendorRepository: CoroutineCrudRepository<VendorEntity, String>
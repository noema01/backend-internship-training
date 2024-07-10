package org.example.retail.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="vendors")
data class VendorEntity(
    val id: String? = null,
    val name: String,
    val website: String,
    val phoneNumber: String,
    val countryCode: String

)
package org.example.retail.model

import org.example.retail.entity.VendorEntity
import org.example.retail.exceptions.NotFoundException

data class Vendor(
    val id: String,
    val name: String,
    val website: String,
    val phoneNumber: String,
    val countryCode: String
)
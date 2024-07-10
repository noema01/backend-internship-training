package org.example.retail.model

data class VendorCreationRequest (
    val name: String,
    val website: String,
    val phoneNumber: String,
    val countryCode: String
)
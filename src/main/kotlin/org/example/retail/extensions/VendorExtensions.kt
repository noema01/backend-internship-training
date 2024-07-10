package org.example.retail.extensions

import org.example.retail.entity.VendorEntity
import org.example.retail.exceptions.NotFoundException
import org.example.retail.model.Vendor

fun VendorEntity.toDto(): Vendor {
    return Vendor(
        id = this.id ?: throw NotFoundException("Vendor $id not found!"),
        name = this.name,
        website = this.website,
        phoneNumber = this.phoneNumber,
        countryCode = this.countryCode
    )
}

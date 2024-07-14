package net.noema.inventory.extensions

import net.noema.inventory.entity.VendorEntity
import net.noema.inventory.exceptions.NotFoundException
import net.noema.inventory.model.Vendor

fun VendorEntity.toDto(): Vendor {
    return Vendor(
        id = this.id ?: throw NotFoundException("Vendor $id not found!"),
        name = this.name,
        website = this.website,
        phoneNumber = this.phoneNumber,
        countryCode = this.countryCode
    )
}

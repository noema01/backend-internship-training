package net.noema.graphql

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class ProductQueries : Query {

    @GraphQLDescription("Retrieves a product by id")
    @Deprecated("Use our new api instead", replaceWith = ReplaceWith("productV2"))
    suspend fun product(id: String): Product {
        println("I am querying inventory service")

        return Product(
            id = id,
            name = "doesn't matter",
            vendorId = "doesn't matter",
            price = 123.2
        )
    }

//    suspend fun products(): String = "This is your product $id"

}


data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val vendorId: String
) {

    suspend fun vendor(): Vendor {
        // querying the real vendor controller
        return Vendor(
            id = "123123",
            name = "Dell",
            website = "www.google.com",
            phoneNumber = "123123123",
            countryCode = "USA",
        )
    }
}


data class Vendor(
    val id: String,
    val name: String,
    val website: String,
    val phoneNumber: String,
    @GraphQLIgnore
    val countryCode: String
) {

    suspend fun country(): Country {
        // countryClient.getCountryByCode(countryCode)
        return Country(
            code = countryCode,
            name = "Any country name",
            currencyCode = "USD"
        )
    }
}


data class Country(
    val name: String,
    val code: String,
    val currencyCode: String,
) {
    suspend fun currency(): Currency = Currency(
        code = currencyCode,
        name = "US Dollars"
    )
}

data class Currency(
    val name: String,
    val code: String
)
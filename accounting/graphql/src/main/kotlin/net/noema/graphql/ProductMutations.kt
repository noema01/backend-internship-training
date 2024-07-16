package net.noema.graphql

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.stereotype.Component

@Component
class ProductMutations : Mutation {

    @GraphQLDescription("Creates a new product")
    suspend fun productCreate(
        product: Product
    ): Product = product
}
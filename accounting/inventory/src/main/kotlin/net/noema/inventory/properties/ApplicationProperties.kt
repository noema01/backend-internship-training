package net.noema.inventory.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "retail")
class ApplicationProperties(
    var shippingGatewayBaseUrl: String = ""
)
package org.example.retail

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "retail")
class ApplicationProperties(
    var shippingGatewayBaseUrl: String = ""
)
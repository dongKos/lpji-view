package com.dongko.lpji.authentication

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "security")
class SecurityProperties {
    var noAuthenticationRoutes: List<String> = emptyList()
    var admin = Admin()
    var cors = Cors()

    class Admin {
        var username: String = "admin"
        var password: String = "admin"
    }

    class Cors {
        var allowedOrigins: List<String> = emptyList()
        var allowedOriginPatterns: List<String> = emptyList()
    }
}

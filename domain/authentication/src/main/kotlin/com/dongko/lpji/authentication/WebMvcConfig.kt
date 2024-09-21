package com.dongko.lpji.authentication

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableConfigurationProperties(SecurityProperties::class)
class WebMvcConfig(
    private val securityProperties: SecurityProperties,
) : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins(*securityProperties.cors.allowedOrigins.toTypedArray())
            .allowedOriginPatterns(*securityProperties.cors.allowedOriginPatterns.toTypedArray())
            .maxAge(3600)
    }
}

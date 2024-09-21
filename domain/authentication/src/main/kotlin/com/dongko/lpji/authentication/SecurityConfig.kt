package com.dongko.lpji.authentication

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@EnableConfigurationProperties(SecurityProperties::class)
@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val securityProperties: SecurityProperties,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .csrf { it.disable() }
            .cors { it.disable() }
            .formLogin { it.disable() }
            .authorizeHttpRequests {
                it
                    .requestMatchers(CorsPreFlightRequestMatcher())
                    .permitAll()
                    .requestMatchers(*securityProperties.noAuthenticationRoutes.toTypedArray())
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }.sessionManagement { it.sessionCreationPolicy(STATELESS) }
            .build()

    class CorsPreFlightRequestMatcher : RequestMatcher {
        override fun matches(request: HttpServletRequest): Boolean = CorsUtils.isPreFlightRequest(request)
    }
}

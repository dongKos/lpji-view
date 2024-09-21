package com.dongko.lpji.authentication

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController(
    private val authService: AuthService,
) {
    @GetMapping
    fun getUser(
        @RequestParam id: Long,
    ): String? = authService.findUserById(id)
}

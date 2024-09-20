package com.dongko.lpji.user.adapter.`in`.web

import com.dongko.lpji.user.adapter.`in`.web.UserController.Companion.BASE_URL
import com.dongko.lpji.user.adapter.`in`.web.resource.CreateUserRequestResource
import com.dongko.lpji.user.application.port.`in`.UserCommandUseCase
import com.dongko.lpji.user.application.port.`in`.UserQueryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(BASE_URL)
class UserController(
    private val userCommandUseCase: UserCommandUseCase,
    private val userQueryUseCase: UserQueryUseCase,
) {
    companion object {
        const val BASE_URL = "/api/v1/users"
    }

    @PostMapping
    fun createUser(
        @RequestBody createUserRequestResource: CreateUserRequestResource,
    ): ResponseEntity<Long> {
        val userId = userCommandUseCase.createUser(createUserRequestResource.toCommand())
        return ResponseEntity.ok(userId)
    }
}

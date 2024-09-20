package com.dongko.lpji.user.application.port.`in`.command

data class CreateUserCommand(
    val name: String,
) {
    init {
        require(name.isNotBlank()) { "Name must not be blank" }
    }
}

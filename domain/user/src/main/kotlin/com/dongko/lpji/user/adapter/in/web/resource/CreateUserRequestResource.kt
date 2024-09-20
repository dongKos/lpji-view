package com.dongko.lpji.user.adapter.`in`.web.resource

import com.dongko.lpji.user.application.port.`in`.command.CreateUserCommand

data class CreateUserRequestResource(
    val name: String,
) {
    fun toCommand(): CreateUserCommand {
        return CreateUserCommand(name)
    }
}

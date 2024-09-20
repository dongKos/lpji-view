package com.dongko.lpji.user.application.port.`in`

import com.dongko.lpji.user.application.port.`in`.command.CreateUserCommand

interface UserCommandUseCase {
    fun createUser(createUserCommand: CreateUserCommand): Long
}

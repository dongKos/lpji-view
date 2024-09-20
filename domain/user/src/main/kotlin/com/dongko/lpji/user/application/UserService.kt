package com.dongko.lpji.user.application

import com.dongko.lpji.user.UserDto
import com.dongko.lpji.user.UserReader
import com.dongko.lpji.user.application.port.`in`.UserCommandUseCase
import com.dongko.lpji.user.application.port.`in`.UserQueryUseCase
import com.dongko.lpji.user.application.port.`in`.command.CreateUserCommand
import com.dongko.lpji.user.application.port.out.UserCommandPort
import com.dongko.lpji.user.application.port.out.UserQueryPort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userCommandPort: UserCommandPort,
    private val userQueryPort: UserQueryPort,
) : UserQueryUseCase, UserCommandUseCase, UserReader {
    override fun createUser(createUserCommand: CreateUserCommand): Long {
        // check username duplication
        userQueryPort.findUserByName(createUserCommand.name)?.let {
            throw IllegalStateException("User with name ${createUserCommand.name} already exists")
        }

        return userCommandPort.createUser(createUserCommand.name)
    }

    override fun findById(id: Long): UserDto? {
        return userQueryPort.findById(id)?.toUserDto()
    }
}

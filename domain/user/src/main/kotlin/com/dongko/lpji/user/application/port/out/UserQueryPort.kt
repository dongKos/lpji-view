package com.dongko.lpji.user.application.port.out

import com.dongko.lpji.user.domain.User

interface UserQueryPort {
    fun findUserByName(name: String): User?

    fun findById(id: Long): User?
}

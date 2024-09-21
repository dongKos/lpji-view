package com.dongko.lpji.authentication

import com.dongko.lpji.user.UserReader
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userReader: UserReader,
) {
    fun findUserById(id: Long): String? = userReader.findById(id)?.name
}

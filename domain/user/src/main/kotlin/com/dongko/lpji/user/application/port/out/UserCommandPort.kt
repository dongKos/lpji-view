package com.dongko.lpji.user.application.port.out

interface UserCommandPort {
    fun createUser(name: String): Long
}

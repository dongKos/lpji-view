package com.dongko.lpji.user

interface UserReader {
    fun findById(id: Long): UserDto?
}

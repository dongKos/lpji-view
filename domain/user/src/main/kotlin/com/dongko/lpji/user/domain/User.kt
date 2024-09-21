package com.dongko.lpji.user.domain

import com.dongko.lpji.user.UserDto

class User(
    val id: Long,
    val name: String,
) {
    fun toUserDto(): UserDto =
        UserDto(
            id = id,
            name = name,
        )
}

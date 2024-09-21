package com.dongko.lpji.user.adapter.out.persistence

import com.dongko.lpji.user.application.port.out.UserCommandPort
import com.dongko.lpji.user.application.port.out.UserQueryPort
import com.dongko.lpji.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
) : UserQueryPort,
    UserCommandPort {
    override fun createUser(name: String): Long = userRepository.save(UserEntity(name)).identifier

    override fun findUserByName(name: String): User? = userRepository.findByName(name)?.toUser()

    override fun findById(id: Long): User? = userRepository.findById(id).map { it.toUser() }.orElse(null)
}

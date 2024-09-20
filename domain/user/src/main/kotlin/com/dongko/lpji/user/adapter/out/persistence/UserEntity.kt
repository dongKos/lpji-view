package com.dongko.lpji.user.adapter.out.persistence

import com.dongko.lpji.persistence.AuditBase
import com.dongko.lpji.persistence.Identifiable
import com.dongko.lpji.user.domain.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    val name: String,
) : AuditBase(), Identifiable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long? = null

    fun toUser(): User {
        return User(
            id = identifier,
            name = name,
        )
    }
}

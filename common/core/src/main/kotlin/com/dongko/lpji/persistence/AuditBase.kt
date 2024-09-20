package com.dongko.lpji.persistence

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.boot.actuate.audit.listener.AuditListener
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

@MappedSuperclass
@EntityListeners(AuditListener::class)
abstract class AuditBase {
    @CreatedDate
    @Column(updatable = false)
    var createdAt: Instant = Instant.now()

    @LastModifiedDate
    var updatedAt: Instant? = null
}

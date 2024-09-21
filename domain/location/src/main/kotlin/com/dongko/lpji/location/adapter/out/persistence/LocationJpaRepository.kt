package com.dongko.lpji.location.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationJpaRepository : JpaRepository<LocationEntity, Long> {
    fun findByNameIn(names: List<String>): List<LocationEntity>
}

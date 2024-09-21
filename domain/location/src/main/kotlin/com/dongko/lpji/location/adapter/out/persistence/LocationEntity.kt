package com.dongko.lpji.location.adapter.out.persistence

import com.dongko.lpji.persistence.AuditBase
import com.dongko.lpji.persistence.Identifiable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "location")
class LocationEntity(
    val name: String,
    var pricePerSquareMeter: String,
) : AuditBase(),
    Identifiable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null
}

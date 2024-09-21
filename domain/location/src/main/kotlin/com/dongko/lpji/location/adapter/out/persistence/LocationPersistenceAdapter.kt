package com.dongko.lpji.location.adapter.out.persistence

import com.dongko.lpji.location.application.port.out.LocationQueryPort
import com.dongko.lpji.location.domain.Location
import org.springframework.stereotype.Service

@Service
class LocationPersistenceAdapter(
    private val locationJpaRepository: LocationJpaRepository,
) : LocationQueryPort {
    override fun getLocations(names: List<String>): List<Location> =
        locationJpaRepository.findByNameIn(names).map {
            Location(
                id = it.identifier,
                name = it.name,
                pricePerSquareMeter = it.pricePerSquareMeter,
            )
        }
}

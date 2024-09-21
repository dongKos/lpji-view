package com.dongko.lpji.location.application.port

import com.dongko.lpji.location.adapter.`in`.web.resource.LocationRequestResource
import com.dongko.lpji.location.adapter.`in`.web.resource.LocationResponseResource
import com.dongko.lpji.location.application.port.`in`.LocationQueryUserCase
import com.dongko.lpji.location.application.port.out.LocationQueryPort
import org.springframework.stereotype.Service

@Service
class LocationService(
    private val locationQueryPort: LocationQueryPort,
) : LocationQueryUserCase {
    override fun getLocations(locationRequestResource: LocationRequestResource): List<LocationResponseResource> =
        locationQueryPort.getLocations(locationRequestResource.names).map {
            LocationResponseResource(
                id = it.id,
                name = it.name,
                pricePerSquareMeter = it.pricePerSquareMeter,
            )
        }
}

package com.dongko.lpji.location.adapter.`in`.web

import com.dongko.lpji.location.adapter.`in`.web.LocationController.Companion.LOCATION_BASE_URL
import com.dongko.lpji.location.adapter.`in`.web.resource.LocationRequestResource
import com.dongko.lpji.location.adapter.`in`.web.resource.LocationResponseResource
import com.dongko.lpji.location.application.port.`in`.LocationQueryUserCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(LOCATION_BASE_URL)
class LocationController(
    private val locationQueryUserCase: LocationQueryUserCase,
) {
    companion object {
        const val LOCATION_BASE_URL = "/api/v1/locations"
    }

    @PostMapping
    fun getLocations(
        @RequestBody locationRequestResource: LocationRequestResource,
    ): ResponseEntity<List<LocationResponseResource>> = ResponseEntity.ok(locationQueryUserCase.getLocations(locationRequestResource))
}

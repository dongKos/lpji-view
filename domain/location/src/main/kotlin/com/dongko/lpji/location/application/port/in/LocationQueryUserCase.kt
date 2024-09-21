package com.dongko.lpji.location.application.port.`in`

import com.dongko.lpji.location.adapter.`in`.web.resource.LocationRequestResource
import com.dongko.lpji.location.adapter.`in`.web.resource.LocationResponseResource

interface LocationQueryUserCase {
    fun getLocations(locationRequestResource: LocationRequestResource): List<LocationResponseResource>
}

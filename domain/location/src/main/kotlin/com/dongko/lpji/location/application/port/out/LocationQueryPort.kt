package com.dongko.lpji.location.application.port.out

import com.dongko.lpji.location.domain.Location

interface LocationQueryPort {
    fun getLocations(names: List<String>): List<Location>
}

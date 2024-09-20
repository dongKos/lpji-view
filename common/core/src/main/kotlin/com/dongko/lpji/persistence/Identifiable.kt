package com.dongko.lpji.persistence

interface Identifiable<ID> {
    val id: ID?
    val identifier: ID
        get() = id!!
}

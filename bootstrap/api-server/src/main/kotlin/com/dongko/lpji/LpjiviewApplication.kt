package com.dongko.lpji

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
class LpjiviewApplication

fun main(args: Array<String>) {
    runApplication<LpjiviewApplication>(*args)
}

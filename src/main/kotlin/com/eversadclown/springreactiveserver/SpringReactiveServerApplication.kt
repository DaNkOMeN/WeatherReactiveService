package com.eversadclown.springreactiveserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringReactiveServerApplication

fun main(args: Array<String>) {
    runApplication<SpringReactiveServerApplication>(*args)
}

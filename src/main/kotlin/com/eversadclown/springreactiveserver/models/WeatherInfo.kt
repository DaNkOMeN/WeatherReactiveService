package com.eversadclown.springreactiveserver.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

//hibernate need default contructor for using
@Entity
data class WeatherInfo(
    var region: String = "",
    var country: String = "",
    var state: String = "",
    var city: String = "",
    var localDate: LocalDate = LocalDate.now(),
    var avgTemperature: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
package com.eversadclown.springreactiveserver.models

import org.springframework.data.annotation.Id
import java.time.LocalDate

//hibernate need default constructor for using
data class WeatherInfo(
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var region: String = "",
    var country: String = "",
    var state: String = "",
    var city: String = "",
    var localDate: LocalDate = LocalDate.now(),
    var avgTemperature: String = ""
)
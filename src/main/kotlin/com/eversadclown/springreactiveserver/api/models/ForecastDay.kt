package com.eversadclown.springreactiveserver.api.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class ForecastDay (
    val date: LocalDate,
    @JsonProperty("day") val temperature: Temperature,
)
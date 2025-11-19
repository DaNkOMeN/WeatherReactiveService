package com.eversadclown.springreactiveserver.api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Temperature(
    @JsonProperty("avgtemp_f") val avgF: Double,
)

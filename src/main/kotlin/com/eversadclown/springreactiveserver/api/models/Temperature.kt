package com.eversadclown.springreactiveserver.api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Temperature(
    @JsonProperty("maxtemp_c") val maxC: Double,
    @JsonProperty("maxtemp_f") val maxF: Double,
    @JsonProperty("mintemp_c") val minC: Double,
    @JsonProperty("mintemp_f") val minF: Double,
    @JsonProperty("avgtemp_c") val avgC: Double,
    @JsonProperty("avgtemp_f") val avgF: Double,
)

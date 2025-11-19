package com.eversadclown.springreactiveserver.api

import com.fasterxml.jackson.annotation.JsonProperty

data class Location (
    @JsonProperty("name") val city: String,
    val region: String,
    val country: String,
)
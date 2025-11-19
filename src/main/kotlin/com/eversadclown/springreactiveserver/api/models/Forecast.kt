package com.eversadclown.springreactiveserver.api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Forecast(@JsonProperty("forecastday") val days: List<ForecastDay>)

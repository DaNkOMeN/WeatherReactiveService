package com.eversadclown.springreactiveserver.api.models

import com.eversadclown.springreactiveserver.models.WeatherInfo

data class WeatherApiResponse(
    val location: Location,
    val forecast: Forecast,
) {

    fun toWeatherInfoList(): List<WeatherInfo> {
        return forecast.days.map {
            WeatherInfo(
                id = null,
                region = location.region,
                country = location.country,
                "",
                city = location.city,
                localDate = it.date,
                avgTemperature = "{${it.temperature.avgF}.2f}"
            )
        }
    }
}

package com.eversadclown.springreactiveserver.services

import com.eversadclown.springreactiveserver.models.WeatherInfo
import com.eversadclown.springreactiveserver.repository.WeatherRepository
import org.springframework.stereotype.Service

@Service //по умолчанию singleton
class WeatherService(
    private val weatherRepository: WeatherRepository,
) {

    fun getAll(): List<WeatherInfo> = weatherRepository.findAll()

    fun getAllCityIgnoreCase(city: String): List<WeatherInfo> {
        return weatherRepository.findAllCityIgnoreCase(city)
    }

}
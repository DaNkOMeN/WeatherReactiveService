package com.eversadclown.springreactiveserver.controllers

import com.eversadclown.springreactiveserver.models.WeatherInfo
import com.eversadclown.springreactiveserver.services.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class WeatherController(
    private val weatherService: WeatherService,
) {

    @GetMapping
    fun getAll(): List<WeatherInfo> = weatherService.getAll();

    @GetMapping("/city/{city}")
    fun findAllCityIgnoreCase(@PathVariable city: String): List<WeatherInfo> {
        return weatherService.getAllCityIgnoreCase(city)
    }

}
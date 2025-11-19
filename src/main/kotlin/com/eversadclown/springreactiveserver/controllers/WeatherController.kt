package com.eversadclown.springreactiveserver.controllers

import com.eversadclown.springreactiveserver.models.WeatherInfo
import com.eversadclown.springreactiveserver.services.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/weather")
class WeatherController(
    private val weatherService: WeatherService,
) {

    @GetMapping
    fun getAll(): Flux<WeatherInfo> = weatherService.getAll();

    @GetMapping("/city/{city}")
    fun findAllCityIgnoreCase(@PathVariable city: String): Flux<WeatherInfo> {
        return weatherService.getForCity(city)
    }

}
package com.eversadclown.springreactiveserver.services

import com.eversadclown.springreactiveserver.api.client.WeatherApiClient
import com.eversadclown.springreactiveserver.models.WeatherInfo
import com.eversadclown.springreactiveserver.repositories.WeatherRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service //по умолчанию singleton
class WeatherService(
    private val weatherRepository: WeatherRepository,
    private val weatherApiClient: WeatherApiClient,
) {

    fun getAll(): Flux<WeatherInfo> = weatherRepository.findAll()

    fun getAllCityIgnoreCase(city: String): Flux<WeatherInfo> {
        return weatherRepository.findAllByCityIgnoreCase(city)
    }

    fun getForCity(city: String): Flux<WeatherInfo> {
        return weatherRepository.findAllByCityIgnoreCase(city)
            .switchIfEmpty(
                weatherApiClient
                    .getWeather(city)
                    .flatMapMany { response ->
                        weatherRepository.saveAll(response.toWeatherInfoList())
                    }
            )
    }

}
package com.eversadclown.springreactiveserver.api.client

import com.eversadclown.springreactiveserver.api.models.WeatherApiResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class WeatherApiClient(
    val webClient: WebClient,
    @Value("\${weatherapi.host}") val host: String,
    @Value("\${weatherapi.api-key}") val apiKey: String
) {
    fun getWeather(city: String): Mono<WeatherApiResponse> {
        return webClient
            .get()
            .uri("$host/v1/forecast.json?key=$apiKey&q=$city&days=7")
            .exchangeToMono { it.bodyToMono(WeatherApiResponse::class.java) }
            .doFirst { logger.info("Get weather forecast for city $city") }
            .doOnError { logger.error("Cannot get weather forecast for city $city") }
            .doOnSuccess { logger.info("Weather forecast for city $city") }
    }

    companion object {
        val logger = LoggerFactory.getLogger(WeatherApiClient::class.java)!!
    }
}
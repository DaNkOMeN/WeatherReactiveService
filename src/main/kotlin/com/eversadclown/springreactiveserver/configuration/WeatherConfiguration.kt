package com.eversadclown.springreactiveserver.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ReactorResourceFactory
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.time.temporal.ChronoUnit

@Configuration
//@EnableJpaRepositories(basePackages = ["com.eversadclown.springreactiveserver.repositories"])
class WeatherConfiguration {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun resourceFactory(): ReactorResourceFactory {
        return ReactorResourceFactory()
    }

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .clientConnector(
                ReactorClientHttpConnector(
                    resourceFactory()
                ) { client ->
                    client.responseTimeout(java.time.Duration.of(10, ChronoUnit.SECONDS))
                }
            ).build()
    }

}
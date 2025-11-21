package com.eversadclown.springreactiveserver.configuration

import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class R2dbcConfiguration {

    //для подключения к реактивному хранилищу PostgreSQL
    @Bean
    fun connectionFactory(
        @Value("\${spring.r2dbc.url}") url: String,
        @Value("\${spring.r2dbc.username}") username: String,
        @Value("\${spring.r2dbc.password}") password: String
    ): ConnectionFactory {
        return ConnectionFactoryBuilder
            .withUrl(url)
            .username(username)
            .password(password)
            .build()
    }

}
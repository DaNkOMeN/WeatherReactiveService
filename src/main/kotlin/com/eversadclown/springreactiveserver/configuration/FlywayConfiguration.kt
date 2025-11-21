package com.eversadclown.springreactiveserver.configuration

import org.flywaydb.core.Flyway
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FlywayConfiguration {

    //Для настройки подключения к flyway для миграции
    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .url("jdbc:postgresql://localhost:5432/myjira")
            .username("postgres")
            .password("postgres")
            .driverClassName("org.postgresql.Driver")
            .build()
    }

    @Bean(initMethod = "migrate")
    fun flyway(dataSource: DataSource): Flyway {
        return Flyway.configure()
            .dataSource(dataSource)
            .baselineOnMigrate(true)  // Создаёт baseline при первом запуске
            .baselineVersion("0")     // Начальная версия миграций
            .validateOnMigrate(false) // Отключает валидацию (для гибкости)
            .outOfOrder(true)         // Разрешает применять миграции не по порядку
            .locations("classpath:db/migration")
            .load();
    }

}
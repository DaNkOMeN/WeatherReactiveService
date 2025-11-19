package com.eversadclown.springreactiveserver.repository

import com.eversadclown.springreactiveserver.models.WeatherInfo
import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WeatherRepository : ListCrudRepository<WeatherInfo, Long> {

    fun findAllCityIgnoreCase(city: String): List<WeatherInfo>

}
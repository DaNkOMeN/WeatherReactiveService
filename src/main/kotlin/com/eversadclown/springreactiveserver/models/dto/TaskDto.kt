package com.eversadclown.springreactiveserver.models.dto

import com.eversadclown.springreactiveserver.models.Task
import jakarta.validation.constraints.NotBlank

data class TaskDto(
    val id: Long? = null,
    @field:NotBlank(message = "Number must be not blank") val number: String,
    @field:NotBlank(message = "Description must be not blank") val description: String,
) {
    fun toModel(): Task {
        return Task(number = number, description = description)
    }
}
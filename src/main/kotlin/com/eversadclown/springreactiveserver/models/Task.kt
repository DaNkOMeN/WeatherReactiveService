package com.eversadclown.springreactiveserver.models

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table

@Table("tasks")
data class Task(
    @Id
    val id: Long? = null,
    val number: String? = null,
    val description: String? = null,

    //у задачи может быть много пользователей
    @Transient
    val users: MutableSet<User> = mutableSetOf(),
)

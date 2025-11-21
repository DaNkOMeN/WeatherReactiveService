package com.eversadclown.springreactiveserver.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user_tasks")
data class UserTask(
    @Id
    val id: Long,
    val taskId: Long,
    val userId: Long,
)

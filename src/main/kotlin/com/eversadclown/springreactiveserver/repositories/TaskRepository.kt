package com.eversadclown.springreactiveserver.repositories

import com.eversadclown.springreactiveserver.models.Task
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface TaskRepository : ReactiveCrudRepository<Task, Long> {

}
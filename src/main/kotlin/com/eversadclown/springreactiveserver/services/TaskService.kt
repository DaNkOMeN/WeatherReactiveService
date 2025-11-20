package com.eversadclown.springreactiveserver.services

import com.eversadclown.springreactiveserver.models.Task
import com.eversadclown.springreactiveserver.models.dto.TaskDto
import com.eversadclown.springreactiveserver.repositories.TaskRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TaskService(
    private val taskRepository: TaskRepository,
) {

    fun getAll(): Flux<Task> = taskRepository.findAll()

    fun getById(id: Long): Mono<Task> {
        return taskRepository
            .findById(id)
            .switchIfEmpty(
                Mono.error(IllegalArgumentException("Not found with id $id"))
            )
    }

    fun save(task: TaskDto): Mono<Task> {
        return taskRepository.save(task.toModel())
    }

    fun update(task: TaskDto): Mono<Task> {
        return task
            .id
            ?.let { id ->
                getById(id)
                    .flatMap {
                        taskRepository.save(
                            Task(
                                id = id,
                                number = task.number,
                                description = task.description
                            )
                        )
                    }
            } ?: Mono.error(IllegalArgumentException("Not found with number ${task.number}"))
    }

    fun delete(task: TaskDto): Mono<Void> {
        return task.id?.let { id -> taskRepository.deleteById(id) } ?: Mono.empty()
    }

}
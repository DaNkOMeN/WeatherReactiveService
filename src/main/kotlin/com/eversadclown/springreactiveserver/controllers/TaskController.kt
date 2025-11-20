package com.eversadclown.springreactiveserver.controllers

import com.eversadclown.springreactiveserver.models.Task
import com.eversadclown.springreactiveserver.models.dto.TaskDto
import com.eversadclown.springreactiveserver.services.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService,
) {

    @GetMapping
    fun getAllTasks(): Flux<Task> = taskService.getAll();

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): Mono<Task> {
        return taskService.getById(id)
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody task:TaskDto): Mono<Task> {
        return taskService.save(task);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    fun updateTask(@RequestBody task:TaskDto): Mono<Task> {
        return taskService.update(task);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@RequestBody task:TaskDto): Mono<Void> {
        return taskService.delete(task);
    }
}
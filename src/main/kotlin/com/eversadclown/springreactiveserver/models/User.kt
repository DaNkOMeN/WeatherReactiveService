package com.eversadclown.springreactiveserver.models

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table

//hibernate need default constructor for using
@Table("users")
data class User(
    @Id
    val id: Long,
    val userName: String,
    val password: String, //захешированный должен быть
    val email: String,
    val role: MutableSet<Role> = mutableSetOf(),
    @Transient
    val tasks: MutableSet<Task> = mutableSetOf(), //из-за проблемы many-to-many нужен доп конструктор
) {

    //Вызывается чтобы не передавались все таски
    @PersistenceCreator
    constructor(
        id: Long,
        userName: String,
        password: String,
        email: String
    ) : this(id, userName, password, email, mutableSetOf(), mutableSetOf())

}
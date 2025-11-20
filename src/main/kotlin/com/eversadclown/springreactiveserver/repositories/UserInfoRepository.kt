package com.eversadclown.springreactiveserver.repositories

import com.eversadclown.springreactiveserver.models.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserInfoRepository : ReactiveCrudRepository<User, Long> {
}
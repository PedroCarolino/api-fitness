package com.app.apiFitness.repository

import com.app.apiFitness.model.user
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<user, Long>
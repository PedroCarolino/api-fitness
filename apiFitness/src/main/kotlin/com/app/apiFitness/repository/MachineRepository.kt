package com.app.apiFitness.repository

import com.app.apiFitness.repository.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MachineRepository : JpaRepository<UserEntity, Long> {
}
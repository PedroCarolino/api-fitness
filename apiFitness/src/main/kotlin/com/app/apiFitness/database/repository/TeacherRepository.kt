package com.app.apiFitness.database.repository

import com.app.apiFitness.database.repository.entity.TeacherEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository: JpaRepository<TeacherEntity, Long>
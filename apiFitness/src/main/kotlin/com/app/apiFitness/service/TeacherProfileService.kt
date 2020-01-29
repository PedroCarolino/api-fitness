package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.database.repository.entity.TeacherEntity
import com.app.apiFitness.database.repository.entity.UserEntity

interface TeacherProfileService {
    fun create(teacherProfileRequestDTO: TeacherProfileRequestDTO)
    fun verifyIfEmailIsValid(email: String): Boolean
    fun createUser(teacherProfileRequestDTO: TeacherProfileRequestDTO) : UserEntity
    fun createTeacher(userId: Long?,CREF: String?) : TeacherEntity
}
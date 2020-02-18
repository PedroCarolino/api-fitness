package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.repository.entity.TeacherEntity
import com.app.apiFitness.repository.entity.UserEntity

interface TeacherProfileService {
    fun create(teacherProfileRequestDTO: TeacherProfileRequestDTO)
    fun verifyIfEmailIsValid(email: String): Boolean
    fun createUser(teacherProfileRequestDTO: TeacherProfileRequestDTO) : UserEntity
    fun createTeacher(userId: Int?,CREF: String?) : TeacherEntity

}
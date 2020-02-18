package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.model.UserProfileModel
import com.app.apiFitness.repository.entity.TeacherEntity
import com.app.apiFitness.repository.entity.UserEntity


interface UserService {
    fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity
    fun createTeacher(teacherProfileRequestDTO: TeacherProfileRequestDTO)
    fun verifyIfEmailIsValid(email: String): Boolean
    fun createStudent(userProfileRequestDTO: UserProfileRequestDTO)

}
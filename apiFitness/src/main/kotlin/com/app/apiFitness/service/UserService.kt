package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.repository.entity.UserEntity


interface UserService {
    fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity
    fun emailExist(email: String): Boolean
    fun createTeacher(teacherProfileRequestDTO: TeacherProfileRequestDTO)
    fun createStudent(userProfileRequestDTO: UserProfileRequestDTO)

}
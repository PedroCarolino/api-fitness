package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.UserProfileRequestDTO
import com.app.apiFitness.repository.entity.UserEntity


interface UserService {
    fun create(userProfileRequestDTO: UserProfileRequestDTO)
    fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity

}
package com.app.apiFitness.service.impl

import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.repository.UserRepository
import com.app.apiFitness.repository.entity.UserEntity
import com.app.apiFitness.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
        private val userRepository: UserRepository): UserService {

    override fun create(userProfileRequestDTO: UserProfileRequestDTO) {
        val userEntity = UserEntity(userProfileRequestDTO.user.id,
                userProfileRequestDTO.user.email,
                userProfileRequestDTO.user.password)
        userRepository.save(userEntity)
    }

    override fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity {
        val userEntity = UserEntity(userProfileRequestDTO.user.id,
                userProfileRequestDTO.user.email,
                userProfileRequestDTO.user.password)
        return userRepository.save(userEntity)
    }
}

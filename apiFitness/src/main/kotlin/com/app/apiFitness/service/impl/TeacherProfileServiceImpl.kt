package com.app.apiFitness.service.impl

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.database.repository.TeacherRepository
import com.app.apiFitness.database.repository.UserRepository
import com.app.apiFitness.database.repository.entity.TeacherEntity
import com.app.apiFitness.database.repository.entity.UserEntity
import com.app.apiFitness.service.TeacherProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeacherProfileServiceImpl @Autowired constructor(
        private val userRepository: UserRepository,
        private val teacherRepository: TeacherRepository): TeacherProfileService {

    override fun create(teacherProfileRequestDTO: TeacherProfileRequestDTO) {
        if (verifyEmail(teacherProfileRequestDTO.user.email)) {
            createTeacherUser(teacherProfileRequestDTO)
            createTeacher(teacherProfileRequestDTO.user.id)
        }
    }

    override fun verifyEmail(email: String): Boolean {
        return userRepository.findByEmail(email)
    }

    override fun createUser(teacherProfileRequestDTO: TeacherProfileRequestDTO): UserEntity {
        val userEntity = UserEntity(teacherProfileRequestDTO.user)
        userEntity.password = bCryptPasswordEncoder.encode(userEntity.password)
        return userRepository.save(userEntity)
    }

    override fun createTeacherUser(teacherProfileRequestDTO: TeacherProfileRequestDTO) {
        createUser(teacherProfileRequestDTO)
    }

    override fun createTeacher(userId: Long?): TeacherEntity {
        val teacherEntity = TeacherEntity(userId)
        return teacherRepository.save(teacherEntity)
    }


}
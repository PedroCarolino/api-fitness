package com.app.apiFitness.service.impl

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.repository.TeacherRepository
import com.app.apiFitness.repository.UserRepository
import com.app.apiFitness.repository.entity.TeacherEntity
import com.app.apiFitness.repository.entity.UserEntity
import com.app.apiFitness.service.TeacherProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeacherProfileServiceImpl @Autowired constructor(
        private val userRepository: UserRepository,
        private val teacherRepository: TeacherRepository): TeacherProfileService {

    override fun create(teacherProfileRequestDTO: TeacherProfileRequestDTO) {


    }

    override fun verifyIfEmailIsValid(email: String): Boolean {
        return userRepository.findByEmail(email) == null
    }

    override fun createUser(teacherProfileRequestDTO: TeacherProfileRequestDTO): UserEntity {
        val userEntity = UserEntity(teacherProfileRequestDTO.user.id,
                teacherProfileRequestDTO.user.email,
                teacherProfileRequestDTO.user.password)
        return userRepository.save(userEntity)
    }

    override fun createTeacher(userId: Int?, CREF: String?): TeacherEntity {
        val teacherEntity = TeacherEntity(userId, CREF, userId)
        return teacherRepository.save(teacherEntity)
    }


}
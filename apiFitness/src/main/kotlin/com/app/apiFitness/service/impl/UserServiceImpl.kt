package com.app.apiFitness.service.impl


import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.model.UserProfileModel
import com.app.apiFitness.model.mapper.UserMapper
import com.app.apiFitness.repository.TeacherRepository
import com.app.apiFitness.repository.UserRepository
import com.app.apiFitness.repository.entity.TeacherEntity
import com.app.apiFitness.repository.entity.UserEntity
import com.app.apiFitness.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
        private val userRepository: UserRepository,
        private val teacherRepository: TeacherRepository,
        private val userMapper: UserMapper): UserService {

    override fun verifyIfEmailIsValid(email: String): Boolean {
        return userRepository.findByEmail(email) == null
    }

    override fun createTeacher(teacherProfileRequestDTO: TeacherProfileRequestDTO) {
        val emailIsValid = verifyIfEmailIsValid(teacherProfileRequestDTO.user.email)
        if (emailIsValid) {
            val userEntityDTO = userMapper.mapTo(teacherProfileRequestDTO)
            val userEntity = createUser(userEntityDTO)
            val teacherEntity = TeacherEntity(userEntity.id,teacherProfileRequestDTO.CREF)
            teacherRepository.save(teacherEntity)
        }
    }

    override fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity {
        val userEntity = UserEntity(userProfileRequestDTO.user.id,
                userProfileRequestDTO.user.email,
                userProfileRequestDTO.user.password)
        return userRepository.save(userEntity)
    }



}

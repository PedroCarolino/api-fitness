package com.app.apiFitness.service.impl


import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.model.mapper.UserMapper
import com.app.apiFitness.repository.StudentRepository
import com.app.apiFitness.repository.TeacherRepository
import com.app.apiFitness.repository.UserRepository
import com.app.apiFitness.repository.entity.StudentEntity
import com.app.apiFitness.repository.entity.TeacherEntity
import com.app.apiFitness.repository.entity.UserEntity
import com.app.apiFitness.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
        private val userRepository: UserRepository,
        private val teacherRepository: TeacherRepository,
        private val studentRepository: StudentRepository,
        private val userMapper: UserMapper): UserService {

    override fun verifyIfEmailIsValid(email: String): Boolean {
        return userRepository.findByEmail(email) == null
    }

    override fun createStudent(userProfileRequestDTO: UserProfileRequestDTO) {
        val emailIsValid = verifyIfEmailIsValid(userProfileRequestDTO.user.email)
        if (emailIsValid) {
            val studentEntity = StudentEntity()
            studentEntity.userId = createUser(userProfileRequestDTO).id
            studentRepository.save(studentEntity)
        }
    }

    override fun createTeacher(teacherProfileRequestDTO: TeacherProfileRequestDTO) {
        val emailIsValid = verifyIfEmailIsValid(teacherProfileRequestDTO.user.email)
        if (emailIsValid) {
            val userEntityDTO = userMapper.mapTo(teacherProfileRequestDTO)
            val teacherEntity = TeacherEntity()
            teacherEntity.userId = createUser(userEntityDTO).id
            teacherEntity.CREF = teacherProfileRequestDTO.CREF
            teacherRepository.save(teacherEntity)
        }
    }

    override fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity {
        val userEntity = UserEntity()
        userEntity.id = userProfileRequestDTO.user.id
        userEntity.email= userProfileRequestDTO.user.email
        userEntity.password = userProfileRequestDTO.user.password
        return userRepository.save(userEntity)
    }

}

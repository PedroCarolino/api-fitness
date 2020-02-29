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
import java.io.IOException
import java.util.logging.Logger

@Service
class UserServiceImpl @Autowired constructor(
        private val userRepository: UserRepository,
        private val teacherRepository: TeacherRepository,
        private val studentRepository: StudentRepository,
        private val userMapper: UserMapper): UserService {

    override fun verifyIfEmailIsValid(email: String): Boolean {
        return userRepository.findByEmail(email) == null
    }

    @Throws(Exception::class)
    override fun createStudent(userProfileRequestDTO: UserProfileRequestDTO) {
        try {
            val emailIsValid = verifyIfEmailIsValid(userProfileRequestDTO.user.email)
            if (emailIsValid) {
                val student = StudentEntity()
                student.userId = createUser(userProfileRequestDTO).id
                studentRepository.save(student)
            }
        } catch (e : Exception) {
            throw Exception("could not possible create a student user")
        }
    }

    @Throws(Exception::class)
    override fun createTeacher(teacherProfileRequestDTO: TeacherProfileRequestDTO) {
        try {
            val emailIsValid = verifyIfEmailIsValid(teacherProfileRequestDTO.user.email)
            if (emailIsValid) {
                val userEntityDTO = userMapper.mapTo(teacherProfileRequestDTO)
                val teacher = TeacherEntity()
                teacher.userId = createUser(userEntityDTO).id
                teacher.CREF = teacherProfileRequestDTO.CREF
                teacherRepository.save(teacher)
            }
        } catch (e : Exception) {
            throw Exception("could not possible create a teacher user")
        }
    }

    override fun createUser(userProfileRequestDTO: UserProfileRequestDTO): UserEntity {
        val user = UserEntity.Builder()
                .id(userProfileRequestDTO.user.id)
                .email(userProfileRequestDTO.user.email)
                .password(userProfileRequestDTO.user.password)
                .build()
        return userRepository.save(user)
    }

}

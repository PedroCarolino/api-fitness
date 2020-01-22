package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.UserRequestDTO
import com.app.apiFitness.database.repository.StudentRepository
import com.app.apiFitness.database.repository.TeacherRepository
import com.app.apiFitness.database.repository.UserRepository
import com.app.apiFitness.database.repository.entity.StudentEntity
import com.app.apiFitness.database.repository.entity.TeacherEntity
import com.app.apiFitness.database.repository.entity.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeacherService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var teacherRepository: TeacherRepository
    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder


    fun create(user: UserRequestDTO) {
        createProfessor(createUser(user).id)
    }
    private fun createUser(user: UserRequestDTO): UserEntity {
        var userEntity = UserEntity(user);
        userEntity.password = bCryptPasswordEncoder.encode(userEntity.password)
        return userRepository.save(userEntity)
    }
    private fun createStudent(userId: Int?): StudentEntity {
        var studentEntity = StudentEntity(userId);
        return studentRepository.save(studentEntity)
    }

    private fun createProfessor(userId: Int?): TeacherEntity {
        var teacherEntity = TeacherEntity();
        teacherEntity.userId = userId
        teacherEntity.CREF = "Teste"
        return teacherRepository.save(teacherEntity)
    }
}
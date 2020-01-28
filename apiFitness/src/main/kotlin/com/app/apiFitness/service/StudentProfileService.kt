package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.UserRequestDTO
import com.app.apiFitness.database.repository.StudentRepository
import com.app.apiFitness.database.repository.TeacherRepository
import com.app.apiFitness.database.repository.UserRepository
import com.app.apiFitness.database.repository.entity.StudentEntity
import com.app.apiFitness.database.repository.entity.TeacherEntity
import com.app.apiFitness.database.repository.entity.UserEntity
import com.app.apiFitness.exceptions.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Required
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import javax.persistence.NonUniqueResultException

@Service
class StudentProfileService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    //@Transactional(rollbackFor = [NonUniqueResultException::class])
    //@Transactional(propagation=Propagation.NEVER)
    fun create(user: UserRequestDTO) {
        consultarEmail(user.email)
        createStudentUser(user)
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
    private fun createStudentUser(user: UserRequestDTO) {
        createStudent(createUser(user).id)
    }
    private fun consultarEmail(userEmail: String?) {
        var user = userRepository.findByEmail(userEmail)
        if (user != null){
            throw BusinessException("O email passado já está sendo utilizado")
        }
    }
}
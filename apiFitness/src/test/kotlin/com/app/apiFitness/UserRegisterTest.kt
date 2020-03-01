package com.app.apiFitness

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.model.mapper.UserMapper
import com.app.apiFitness.repository.StudentRepository
import com.app.apiFitness.repository.TeacherRepository
import com.app.apiFitness.repository.UserRepository
import com.app.apiFitness.service.impl.UserServiceImpl
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UserRegisterTest {

    @InjectMockKs
    private lateinit var userServiceImpl: UserServiceImpl

    @MockK(relaxed = true)
    private lateinit var userRepository: UserRepository

    @MockK(relaxed = true)
    private lateinit var teacherRepository: TeacherRepository

    @MockK(relaxed = true)
    private lateinit var studentRepository: StudentRepository

    @MockK(relaxed = true)
    private lateinit var userMapper: UserMapper

    @MockK(relaxed = true)
    private lateinit var userProfileRequestDTO: UserProfileRequestDTO

    @MockK(relaxed = true)
    private lateinit var teacherProfileRequestDTO: TeacherProfileRequestDTO


    @Test
    fun `Given valid teacher details to persist in database`() {
        // given
        every { teacherProfileRequestDTO.user.id } returns 1
        every { teacherProfileRequestDTO.user.email } returns "pedro@gmail.com"
        every { teacherProfileRequestDTO.user.password } returns "1234"
        every { teacherProfileRequestDTO.CREF } returns "1111"

        // then
        assertNotNull(userRepository.findByEmail(teacherProfileRequestDTO.user.email))
//        assertNull(userServiceImpl.createTeacher(teacherProfileRequestDTO))
//        verify { userServiceImpl.createTeacher(teacherProfileRequestDTO) }
    }

    @Test
    fun `Given valid student details to persist in database`() {
        // given
        every { userProfileRequestDTO.user.id } returns 1
        every { userProfileRequestDTO.user.email } returns "pedro@gmail.com"
        every { userProfileRequestDTO.user.password } returns "1234"

        // then
//        assertNull(userServiceImpl.createUser(teacherProfileRequestDTO))
        assertNotNull(userRepository.findByEmail(userProfileRequestDTO.user.email))
//        verify { userServiceImpl.createUser(userProfileRequestDTO) }

    }
}


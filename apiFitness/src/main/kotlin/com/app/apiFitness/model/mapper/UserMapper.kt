package com.app.apiFitness.model.mapper

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import org.springframework.stereotype.Service

@Service
class UserMapper {
    fun mapTo(teacherProfileRequestDTO: TeacherProfileRequestDTO) = UserProfileRequestDTO(
            user = teacherProfileRequestDTO.user
    )
}
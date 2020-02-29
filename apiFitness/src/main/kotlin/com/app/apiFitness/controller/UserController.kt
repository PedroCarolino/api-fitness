package com.app.apiFitness.controller

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.controller.dto.response.StandardResponseDTO
import com.app.apiFitness.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URI

@Controller
@RequestMapping("/create")
class UserController @Autowired constructor(private val teacherService: UserService)  {

    @PostMapping(value=["/teacher"])
    fun createTeacherProfile(@RequestBody teacherProfileRequestDTO: TeacherProfileRequestDTO): ResponseEntity<Any> {
        return ResponseEntity.ok(teacherService.createTeacher(teacherProfileRequestDTO))
    }

    @PostMapping(value=["/student"])
    fun createStudentProfile(@RequestBody userProfileRequestDTO: UserProfileRequestDTO): ResponseEntity<Any> {
        return ResponseEntity.ok(teacherService.createStudent(userProfileRequestDTO))
    }
}
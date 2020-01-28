package com.app.apiFitness.controller;

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO;
import com.app.apiFitness.controller.dto.response.StandardReturnDTO
import com.app.apiFitness.service.TeacherProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI

@Controller
@RequestMapping("/teacherProfile")
class TeacherProfileController {

    @Autowired
    private lateinit var teacherProfileService: TeacherProfileService

    @PostMapping(value = ["/create"])
    fun createTeacherProfile(@PathVariable id: Long, @RequestBody teacherProfileRequestDTO: TeacherProfileRequestDTO): ResponseEntity<StandardReturnDTO> {
        val teacherCreated = teacherProfileService.create(teacherProfileRequestDTO)
        return ResponseEntity.created(URI("")).body(StandardReturnDTO(0,""))
    }
}

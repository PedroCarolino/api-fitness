package com.app.apiFitness.controller;

import com.app.apiFitness.constants.ReturnMessages
import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO;
import com.app.apiFitness.controller.dto.response.StandardReturnDTO
import com.app.apiFitness.exceptions.BusinessException
import com.app.apiFitness.service.TeacherProfileService;
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI

@Controller
@RequestMapping("/teacherProfile")
class TeacherProfileController {
    private val logger = Logger.getLogger(javaClass)
    @Autowired
    private lateinit var teacherProfileService: TeacherProfileService

    @PostMapping(value = ["/create"])
    fun createTeacherProfile(@RequestBody teacherProfileRequestDTO: TeacherProfileRequestDTO): ResponseEntity<StandardReturnDTO> {
        try{
            val teacherCreated = teacherProfileService.create(teacherProfileRequestDTO)
        }

        catch (ex : BusinessException){
            logger.error(ex.message,ex)
            return ResponseEntity.unprocessableEntity().body(StandardReturnDTO(2,ex.message))
        }
        catch (ex : Exception){
            logger.error(ex.message,ex)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(StandardReturnDTO(1, ReturnMessages.INTERNAL_SERVER_ERROR))
        }
        return ResponseEntity.created(URI("")).body(StandardReturnDTO(0,""))
    }
}

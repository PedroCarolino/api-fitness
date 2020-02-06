package com.app.apiFitness.controller

import com.app.apiFitness.controller.dto.UserProfileRequestDTO
import com.app.apiFitness.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/create")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping(value = ["/createUser"])
    fun createUserProfile(@RequestBody userProfileRequestDTO: UserProfileRequestDTO) {
        userService.create(userProfileRequestDTO)
    }
}
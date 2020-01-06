package com.app.apiFitness.controller


import com.app.apiFitness.model.user
import com.app.apiFitness.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LivroController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getAllLivros(): List<user> =
            userRepository.findAll()



}
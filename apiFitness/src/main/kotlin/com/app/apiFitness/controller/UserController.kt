package com.app.apiFitness.controller


import com.app.apiFitness.database.repository.entity.User
import com.app.apiFitness.database.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class LivroController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getAllLivros(): List<User> =
            userRepository.findAll()



}
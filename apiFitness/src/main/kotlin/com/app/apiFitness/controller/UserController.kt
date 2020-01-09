package com.app.apiFitness.controller


import com.app.apiFitness.entity.User
import com.app.apiFitness.repository.UserRepository
import org.springframework.web.bind.annotation.*
//teste
@RestController
@RequestMapping("/api")
class LivroController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getAllLivros(): List<User> =
            userRepository.findAll()



}
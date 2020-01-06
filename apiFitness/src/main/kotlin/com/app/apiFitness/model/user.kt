package com.app.apiFitness.model


import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class user (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val PersonID: Long = 0,

        @get: NotBlank
        val City: String = ""


)
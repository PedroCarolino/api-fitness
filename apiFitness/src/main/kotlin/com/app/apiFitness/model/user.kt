package com.app.apiFitness.model


import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user")
data class user (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        val PersonID: Long = 0,

        @get: NotBlank
        val City: String = ""


)
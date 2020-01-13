package com.app.apiFitness.controller.dto.request

import com.app.apiFitness.constants.enums.UserStatusEnum
import javax.persistence.*


data class UserRequestDTO (
        val id: Long? = null,
        val name: String? = null,
        val nickname: String? = null,
        val email: String = "",
        val address: String? = null,
        val role: UserStatusEnum? = null,
        val password: String? = null,
        val gender: String? = null,
        val age: Long? = null,
        val zipCode: Long? = null,
        val telephone: Long? = null


)
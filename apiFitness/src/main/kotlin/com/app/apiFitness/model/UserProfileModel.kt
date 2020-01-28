package com.app.apiFitness.model

import com.app.apiFitness.constants.enums.UserStatusEnum
import java.net.Inet4Address

data class UserProfileModel (
        val id: Long? = null,
        val name: String? = null,
        val nickname: String? = null,
        val email: String,
        val role: UserStatusEnum? = null,
        val password: String? = null,
        val gender: String? = null,
        val age: Long? = null,
        val zipCode: Long? = null,
        val telephone: Long? = null,
        val address: String? = null
)
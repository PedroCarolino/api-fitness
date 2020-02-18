package com.app.apiFitness.model

import com.app.apiFitness.constants.enums.UserStatusEnum

data class UserProfileModel (
        var id: Int? = null,
        var name: String? = null,
        var nickname: String? = null,
        var email: String = "",
        var password: String? = null,
        var gender: String? = null,
        var role: UserStatusEnum? = null,
        var age: Long? = null,
        var zipCode: Long? = null,
        var telephone: Long? = null,
        var address: String? = null
)
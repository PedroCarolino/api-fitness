package com.app.apiFitness.model

import com.app.apiFitness.constants.enums.UserStatusEnum
import com.app.apiFitness.repository.entity.UserEntity

data class UserProfileModel (
        var id: Long? = null,
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
){
    constructor(user: UserEntity) : this() {
        this.address = user.address
        this.age = user.age?.toLong()
        this.email = user.email.toString()
        this.gender = user.gender
        this.id = user.id
        this.role = user.role
        this.name = user.name
        this.nickname = user.nickname
        this.password = user.password
        this.telephone = user.telephone?.toLong()
        this.zipCode = user.zipCode?.toLong()
    }

}
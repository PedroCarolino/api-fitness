package com.app.apiFitness.database.repository.entity
import com.app.apiFitness.constants.enums.UserStatusEnum
import com.app.apiFitness.controller.dto.request.UserRequestDTO
import javax.persistence.*

@Entity
@Table(name = "user", schema = "db_apifitness")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "name")
        var name: String? = null,
        @Column(name = "nickname")
        var nickname: String? = null,
        @Column(name = "email")
        var email: String? = null,
        @Column(name = "address")
        var address: String? = null,
        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        var role: UserStatusEnum? = null,
        @Column(name = "password")
        var password: String? = null,
        @Column(name = "gender")
        var gender: String? = null,
        @Column(name = "age")
        var age: Long? = null,
        @Column(name = "cep")
        var zipCode: Long? = null,
        @Column(name = "telephone")
        var telephone: Long? = null

){
        constructor(user:UserRequestDTO) : this() {
                this.address = user.address
                this.age = user.age
                this.email = user.email
                this.gender = user.gender
                this.id = user.id
                this.name = user.name
                this.nickname = user.nickname
                this.password = user.password
                this.role = user.role
                this.telephone = user.telephone
                this.zipCode = user.zipCode
        }
}
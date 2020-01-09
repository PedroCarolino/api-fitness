package com.app.apiFitness.database.repository.entity
import com.app.apiFitness.constants.enums.UserStatusEnum
import javax.persistence.*

@Entity
@Table(name = "user", schema = "db_apifitness")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(name = "name")
        val name: String? = null,
        @Column(name = "nickname")
        val nickname: String? = null,
        @Column(name = "email")
        val email: String? = null,
        @Column(name = "address")
        val address: String? = null,
        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        val role: UserStatusEnum? = null,
        @Column(name = "password")
        val password: String? = null,
        @Column(name = "gender")
        val gender: String? = null,
        @Column(name = "age")
        val age: Long? = null,
        @Column(name = "cep")
        val zipCode: Long? = null,
        @Column(name = "telephone")
        val telephone: Long? = null

)
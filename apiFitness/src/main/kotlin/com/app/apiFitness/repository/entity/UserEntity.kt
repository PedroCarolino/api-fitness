package com.app.apiFitness.repository.entity

import com.app.apiFitness.constants.enums.UserStatusEnum
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name = "user")
data class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        @Column(name = "name")
        val name: String? = null,
        @Column(name = "nickname")
        val nickname: String? = null,
        @Column(name = "email")
        val email: String? = null,
        @Column(name = "address")
        val address: String? = null,
        @Column(name = "password")
        val password: String? = null,
        @Column(name = "gender")
        val gender: String? = null,
        @Column(name = "age")
        val age: Int? = null,
        @Column(name = "zipCode")
        val zipCode: Int? = null,
        @Column(name = "telephone")
        val telephone: Int? = null,
        @Column
        @Enumerated(EnumType.STRING)
        var role: UserStatusEnum? = null,
        @OneToOne(mappedBy = "refUserEntity", fetch = FetchType.EAGER, cascade = [(CascadeType.ALL)])
        var refStudentEntities: StudentEntity? = null,
        @OneToOne(mappedBy = "refUserEntity", fetch = FetchType.EAGER, cascade = [(CascadeType.ALL)])
        var refTeacherEntities: TeacherEntity? = null,
        @OneToMany(mappedBy = "refUserEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refGymHasUserEntities: List<GymHasUserEntity>? = null
)
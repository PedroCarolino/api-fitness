package com.app.apiFitness.repository.entity

import com.app.apiFitness.constants.enums.UserStatusEnum
import com.app.apiFitness.model.UserProfileModel
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name = "user")
data class UserEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        @Column(name = "name")
        var name: String? = null,
        @Column(name = "nickname")
        var nickname: String? = null,
        @Column(name = "email")
        var email: String? = null,
        @Column(name = "address")
        var address: String? = null,
        @Column(name = "password")
        var password: String? = null,
        @Column(name = "gender")
        var gender: String? = null,
        @Column(name = "age")
        var age: Int? = null,
        @Column(name = "zipCode")
        var zipCode: Int? = null,
        @Column(name = "telephone")
        var telephone: Int? = null,
        @Column
        @Enumerated(EnumType.STRING)
        var role: UserStatusEnum? = null,
        @OneToOne(mappedBy = "refUserEntity", fetch = FetchType.EAGER, cascade = [(CascadeType.ALL)])
        var refStudentEntities: StudentEntity? = null,
        @OneToOne(mappedBy = "refUserEntity", fetch = FetchType.EAGER, cascade = [(CascadeType.ALL)])
        var refTeacherEntities: TeacherEntity? = null,
        @OneToMany(mappedBy = "refUserEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refGymHasUserEntities: List<GymHasUserEntity>? = null
) {
        data class Builder(
                var id: Int? = null,
                var email: String? = null,
                var password: String? = null
        ) {
                fun id(id: Int?) = apply { this.id = id }
                fun email(email: String?) = apply { this.email = email }
                fun password(password: String?) = apply { this.password = password }
                fun build() = UserEntity(id,email,password)
        }
}

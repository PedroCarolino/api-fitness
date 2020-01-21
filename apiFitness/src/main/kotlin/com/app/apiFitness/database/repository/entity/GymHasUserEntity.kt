package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "gym_has_user", schema = "db_apifitness", catalog = "")
open class GymHasUserEntity {
    @get:Id
    @get:Column(name = "Id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "gym_id", nullable = false, insertable = false, updatable = false)
    var gymId: Int? = null
    @get:Basic
    @get:Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    var userId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "gym_id", referencedColumnName = "id")
    var refGymEntity: GymEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUserEntity: UserEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "gymId = $gymId " +
                    "userId = $userId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as GymHasUserEntity

        if (id != other.id) return false
        if (gymId != other.gymId) return false
        if (userId != other.userId) return false

        return true
    }

}


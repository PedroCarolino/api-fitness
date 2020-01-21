package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "gym", schema = "db_apifitness", catalog = "")
open class GymEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "serialNumber", nullable = true)
    var serialNumber: String? = null
    @get:Basic
    @get:Column(name = "name", nullable = true)
    var name: String? = null

    @get:OneToMany(mappedBy = "refGymEntity")
    var refGymHasMachineEntities: List<GymHasMachineEntity>? = null
    @get:OneToMany(mappedBy = "refGymEntity")
    var refGymHasUserEntities: List<GymHasUserEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "serialNumber = $serialNumber " +
                    "name = $name " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as GymEntity

        if (id != other.id) return false
        if (serialNumber != other.serialNumber) return false
        if (name != other.name) return false

        return true
    }

}


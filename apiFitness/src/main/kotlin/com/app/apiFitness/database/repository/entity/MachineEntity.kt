package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "machine", schema = "db_apifitness", catalog = "")
open class MachineEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = true)
    var name: String? = null

    @get:OneToMany(mappedBy = "refMachineEntity")
    var refGymHasMachineEntities: List<GymHasMachineEntity>? = null
    @get:OneToMany(mappedBy = "refMachineEntity")
    var refTrainingEntities: List<TrainingEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MachineEntity

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

}


package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "gym_has_machine", schema = "db_apifitness", catalog = "")
open class GymHasMachineEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "gym_id", nullable = true, insertable = false, updatable = false)
    var gymId: Int? = null
    @get:Basic
    @get:Column(name = "machine_id", nullable = true, insertable = false, updatable = false)
    var machineId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "gym_id", referencedColumnName = "id")
    var refGymEntity: GymEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "machine_id", referencedColumnName = "id")
    var refMachineEntity: MachineEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "gymId = $gymId " +
                    "machineId = $machineId " +
                    ")"

}


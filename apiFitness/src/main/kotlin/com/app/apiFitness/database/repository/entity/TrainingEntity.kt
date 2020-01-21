package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "training", schema = "db_apifitness", catalog = "")
open class TrainingEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = true)
    var name: String? = null
    @get:Basic
    @get:Column(name = "weight", nullable = true)
    var weight: Int? = null
    @get:Basic
    @get:Column(name = "series", nullable = true)
    var series: Int? = null
    @get:Basic
    @get:Column(name = "repetition", nullable = true)
    var repetition: Int? = null
    @get:Basic
    @get:Column(name = "obs", nullable = true)
    var obs: String? = null
    @get:Basic
    @get:Column(name = "timeBetweenTraining", nullable = true)
    var timeBetweenTraining: String? = null
    @get:Basic
    @get:Column(name = "eccentric", nullable = true)
    var eccentric: Int? = null
    @get:Basic
    @get:Column(name = "concentric", nullable = true)
    var concentric: String? = null
    @get:Basic
    @get:Column(name = "modality", nullable = true)
    var modality: String? = null
    @get:Basic
    @get:Column(name = "machine_id", nullable = false, insertable = false, updatable = false)
    var machineId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "machine_id", referencedColumnName = "id")
    var refMachineEntity: MachineEntity? = null
    @get:OneToMany(mappedBy = "refTrainingEntity")
    var refTrainingHasTrainingsheetEntities: List<TrainingHasTrainingsheetEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "weight = $weight " +
                    "series = $series " +
                    "repetition = $repetition " +
                    "obs = $obs " +
                    "timeBetweenTraining = $timeBetweenTraining " +
                    "eccentric = $eccentric " +
                    "concentric = $concentric " +
                    "modality = $modality " +
                    "machineId = $machineId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TrainingEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (weight != other.weight) return false
        if (series != other.series) return false
        if (repetition != other.repetition) return false
        if (obs != other.obs) return false
        if (timeBetweenTraining != other.timeBetweenTraining) return false
        if (eccentric != other.eccentric) return false
        if (concentric != other.concentric) return false
        if (modality != other.modality) return false
        if (machineId != other.machineId) return false

        return true
    }

}


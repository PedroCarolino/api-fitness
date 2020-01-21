package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "training_has_trainingsheet", schema = "db_apifitness", catalog = "")
open class TrainingHasTrainingsheetEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "training_id", nullable = true, insertable = false, updatable = false)
    var trainingId: Int? = null
    @get:Basic
    @get:Column(name = "trainingSheet_id", nullable = true, insertable = false, updatable = false)
    var trainingSheetId: Int? = null
    @get:Basic
    @get:Column(name = "orderTraining", nullable = true)
    var orderTraining: String? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "training_id", referencedColumnName = "id")
    var refTrainingEntity: TrainingEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "trainingSheet_id", referencedColumnName = "id")
    var refTrainingsheetEntity: TrainingsheetEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "trainingId = $trainingId " +
                    "trainingSheetId = $trainingSheetId " +
                    "orderTraining = $orderTraining " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TrainingHasTrainingsheetEntity

        if (id != other.id) return false
        if (trainingId != other.trainingId) return false
        if (trainingSheetId != other.trainingSheetId) return false
        if (orderTraining != other.orderTraining) return false

        return true
    }

}


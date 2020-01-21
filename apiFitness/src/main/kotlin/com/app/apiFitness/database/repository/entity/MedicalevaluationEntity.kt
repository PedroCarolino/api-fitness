package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "medicalevaluation", schema = "db_apifitness", catalog = "")
open class MedicalevaluationEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "urlImage", nullable = true)
    var urlImage: String? = null
    @get:Basic
    @get:Column(name = "weight", nullable = true)
    var weight: String? = null
    @get:Basic
    @get:Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    var studentId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "student_id", referencedColumnName = "id")
    var refStudentEntity: StudentEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "urlImage = $urlImage " +
                    "weight = $weight " +
                    "studentId = $studentId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MedicalevaluationEntity

        if (id != other.id) return false
        if (urlImage != other.urlImage) return false
        if (weight != other.weight) return false
        if (studentId != other.studentId) return false

        return true
    }

}


package com.app.apiFitness.database.repository.entity

import com.app.apiFitness.controller.dto.request.UserRequestDTO
import javax.persistence.*

@Entity
@Table(name = "student", schema = "db_apifitness", catalog = "")
open class StudentEntity () {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "user_id", nullable = true, insertable = false, updatable = false)
    var userId: Int? = null

    @get:OneToMany(mappedBy = "refStudentEntity")
    var refMedicalevaluationEntities: List<MedicalevaluationEntity>? = null
    @get:OneToMany(mappedBy = "refStudentEntity")
    var refNutritionEntities: List<NutritionEntity>? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUserEntity: UserEntity? = null
    @get:OneToMany(mappedBy = "refStudentEntity")
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null
    @get:OneToMany(mappedBy = "refStudentEntity")
    var refTrainingsheetEntities: List<TrainingsheetEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "userId = $userId " +
                    ")"

    constructor(userId: Int?) : this() {
        this.userId = userId
    }
}


package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "teacher", schema = "db_apifitness", catalog = "")
open class TeacherEntity(id: Long?) {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "CREF", nullable = true)
    var CREF: String? = null
    @get:Basic
    @get:Column(name = "user_id", nullable = false)
    var userId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false,updatable = false)
    var refUserEntity: UserEntity? = null
    @get:OneToMany(mappedBy = "refTeacherEntity")
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null
    @get:OneToMany(mappedBy = "refTeacherEntity")
    var refTrainingsheetEntities: List<TrainingsheetEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "CREF = $CREF " +
                    "userId = $userId " +
                    ")"
}


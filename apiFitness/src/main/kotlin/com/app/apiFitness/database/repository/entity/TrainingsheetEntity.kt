package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "trainingsheet", schema = "db_apifitness", catalog = "")
open class TrainingsheetEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "dateStart", nullable = true)
    var dateStart: java.sql.Date? = null
    @get:Basic
    @get:Column(name = "dateEnd", nullable = true)
    var dateEnd: java.sql.Date? = null
    @get:Basic
    @get:Column(name = "description", nullable = true)
    var description: String? = null
    @get:Basic
    @get:Column(name = "name", nullable = true)
    var name: String? = null
    @get:Basic
    @get:Column(name = "objective", nullable = true)
    var objective: String? = null
    @get:Basic
    @get:Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    var studentId: Int? = null
    @get:Basic
    @get:Column(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    var teacherId: Int? = null

    @get:OneToMany(mappedBy = "refTrainingsheetEntity")
    var refTrainingHasTrainingsheetEntities: List<TrainingHasTrainingsheetEntity>? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "student_id", referencedColumnName = "id")
    var refStudentEntity: StudentEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "teacher_id", referencedColumnName = "id")
    var refTeacherEntity: TeacherEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "dateStart = $dateStart " +
                    "dateEnd = $dateEnd " +
                    "description = $description " +
                    "name = $name " +
                    "objective = $objective " +
                    "studentId = $studentId " +
                    "teacherId = $teacherId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TrainingsheetEntity

        if (id != other.id) return false
        if (dateStart != other.dateStart) return false
        if (dateEnd != other.dateEnd) return false
        if (description != other.description) return false
        if (name != other.name) return false
        if (objective != other.objective) return false
        if (studentId != other.studentId) return false
        if (teacherId != other.teacherId) return false

        return true
    }

}


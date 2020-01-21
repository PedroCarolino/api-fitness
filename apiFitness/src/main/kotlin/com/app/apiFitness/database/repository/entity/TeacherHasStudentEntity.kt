package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "teacher_has_student", schema = "db_apifitness", catalog = "")
open class TeacherHasStudentEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    var teacherId: Int? = null
    @get:Basic
    @get:Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    var studentId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "teacher_id", referencedColumnName = "teacher_has_student_teacher_id")
    var refAppointmentEntity: AppointmentEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "teacher_id", referencedColumnName = "id")
    var refTeacherEntity: TeacherEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "student_id", referencedColumnName = "id")
    var refStudentEntity: StudentEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "teacherId = $teacherId " +
                    "studentId = $studentId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TeacherHasStudentEntity

        if (id != other.id) return false
        if (teacherId != other.teacherId) return false
        if (studentId != other.studentId) return false

        return true
    }

}


package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "appointment", schema = "db_apifitness", catalog = "")
open class AppointmentEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "data", nullable = true)
    var data: java.sql.Timestamp? = null
    @get:Basic
    @get:Column(name = "teacher_has_student_teacher_id", nullable = false, insertable = false, updatable = false)
    var teacherHasStudentTeacherId: Int? = null

    @get:OneToMany(mappedBy = "refAppointmentEntity")
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "data = $data " +
                    "teacherHasStudentTeacherId = $teacherHasStudentTeacherId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as AppointmentEntity

        if (id != other.id) return false
        if (data != other.data) return false
        if (teacherHasStudentTeacherId != other.teacherHasStudentTeacherId) return false

        return true
    }

}


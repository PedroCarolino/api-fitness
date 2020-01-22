package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "teacher_has_student", schema = "db_apifitness", catalog = "")
open class TeacherHasStudentEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "teacher_id", nullable = false)
    var teacherId: Int? = null
    @get:Basic
    @get:Column(name = "student_id", nullable = false)
    var studentId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "teacher_id", referencedColumnName = "teacher_has_student_teacher_id", insertable = false,updatable = false)
    var refAppointmentEntity: AppointmentEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "teacher_id", referencedColumnName = "id",insertable = false, updatable = false)
    var refTeacherEntity: TeacherEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false,updatable = false)
    var refStudentEntity: StudentEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "teacherId = $teacherId " +
                    "studentId = $studentId " +
                    ")"


}


package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import java.security.Timestamp
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name="appointment")
data class AppointmentEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        @Column(name="data")
        val data: Timestamp? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="teacher_has_student_teacher_id", referencedColumnName = "id")
        var refTeacherHasStudentEntity: TeacherHasStudentEntity? = null
)

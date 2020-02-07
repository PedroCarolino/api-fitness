package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="teacher_has_student")
data class TeacherHasStudentEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @ManyToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    var refTeacherEntity: TeacherEntity? = null,
    @ManyToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name="student_id", referencedColumnName = "id")
    var refStudentEntity: StudentEntity? = null,
    @OneToMany(mappedBy = "refTeacherHasStudentEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refAppointmentEntities: List<AppointmentEntity>? = null
)
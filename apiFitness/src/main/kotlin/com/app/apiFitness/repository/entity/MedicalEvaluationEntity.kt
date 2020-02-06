package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name="medicalEvaluation")
class MedicalEvaluationEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "urlImage", nullable = true)
    var urlImage: String? = null,
    @Column(name = "weight", nullable = true)
    var weight: String? = null,
    @ManyToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name="student_id", referencedColumnName = "id")
    var refStudentEntity: StudentEntity? = null
)
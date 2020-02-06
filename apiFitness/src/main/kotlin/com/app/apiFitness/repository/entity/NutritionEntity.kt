package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name="nutrition")
data class NutritionEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        @Column(name = "urlImage", nullable = true)
        var urlImage: String? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="student_id", referencedColumnName = "id")
        var refStudentEntity: StudentEntity? = null
)
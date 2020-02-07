package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="student")
data class StudentEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @OneToOne(mappedBy = "user_id")
    var refUserEntity: UserEntity? = null,
    @OneToMany(mappedBy = "refStudentEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null,
    @OneToMany(mappedBy = "refStudentEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refNutritionEntities: List<NutritionEntity>? = null,
    @OneToMany(mappedBy = "refStudentEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refMedicalEvaluationEntities: List<MedicalEvaluationEntity>? = null,
    @OneToMany(mappedBy = "refStudentEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refTrainingSheetEntities: List<TrainingSheetEntity>? = null

)
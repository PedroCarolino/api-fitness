package com.app.apiFitness.repository.entity

import lombok.*
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name = "teacher")
data class TeacherEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "CREF")
    val CREF: String? = null,
    @OneToOne(mappedBy = "user_id")
    var refUserEntity: UserEntity? = null,
    @OneToMany(mappedBy = "refTeacherEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null,
    @OneToMany(mappedBy = "refTeacherEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refTrainingSheetEntities: List<TrainingSheetEntity>? = null
)
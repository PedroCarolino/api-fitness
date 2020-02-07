package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import java.util.*
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="trainingsheet")
data class TrainingSheetEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(name = "dateStart")
        val dateStart: Date? = null,
        @Column(name = "dateEnd")
        val dateEnd: Date? = null,
        @Column(name = "description")
        val description: String? = null,
        @Column(name = "name")
        val name: String? = null,
        @Column(name = "objective")
        val objective: String? = null,
        @OneToMany(mappedBy = "refTrainingSheetEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refTrainingHasTrainingsheetEntities: List<TrainingHasTrainingsheetEntity>? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="student_id", referencedColumnName = "id")
        var refStudentEntity: StudentEntity? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="teacher_id", referencedColumnName = "id")
        var refTeacherEntity: TeacherEntity? = null
)
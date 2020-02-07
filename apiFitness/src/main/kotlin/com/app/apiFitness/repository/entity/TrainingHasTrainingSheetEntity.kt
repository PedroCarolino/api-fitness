package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Setter
@Getter
@Table(name="training_has_trainingsheet")
data class TrainingHasTrainingSheetEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(name = "orderTraining")
        val orderTraining: String? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="training_id", referencedColumnName = "id")
        var refTrainingEntity: TrainingEntity? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="training_sheet_id", referencedColumnName = "id")
        var refTrainingSheetEntity: TrainingSheetEntity? = null
)
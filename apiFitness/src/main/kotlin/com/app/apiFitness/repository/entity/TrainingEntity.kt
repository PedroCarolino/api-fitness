package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="training")
data class TrainingEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(name = "name")
        val name: String? = null,
        @Column(name = "weight")
        val weight: Int? = null,
        @Column(name = "series")
        val series: Int? = null,
        @Column(name = "repetition")
        val repetition: Int? = null,
        @Column(name = "eccentric")
        val eccentric: Int? = null,
        @Column(name = "concentric")
        val concentric: Int? = null,
        @Column(name = "obs")
        val obs: String? = null,
        @Column(name = "timeBetweenTraining")
        val timeBetweenTraining: String? = null,
        @Column(name = "modality")
        val modality: String? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="machine_id", referencedColumnName = "id")
        var refMachineEntity: MachineEntity? = null,
        @OneToMany(mappedBy = "refTrainingEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refTrainingHasTrainingSheetEntities: List<TrainingHasTrainingSheetEntity>? = null
)
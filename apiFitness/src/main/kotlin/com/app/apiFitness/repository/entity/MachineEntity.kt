package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Setter
@Getter
@Table(name="entity")
data class MachineEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(name="name")
        val name: String? = null,
        @OneToMany(mappedBy = "refMachineEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refGymHasMachineEntities: List<GymHasMachineEntity>? = null,
        @OneToMany(mappedBy = "refMachineEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refTrainingEntities: List<TrainingEntity>? = null
)
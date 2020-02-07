package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="gym_has_machine")
data class GymHasMachineEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="gym_id", referencedColumnName = "id")
        var refGymEntity: GymEntity? = null,
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name="machine_id", referencedColumnName = "id")
        var refMachineEntity: MachineEntity? = null
)
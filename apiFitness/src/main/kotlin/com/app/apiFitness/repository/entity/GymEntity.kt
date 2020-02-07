package com.app.apiFitness.repository.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="gym")
data class GymEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(name = "name")
        val name: String? = null,
        @Column(name = "numberSeries")
        val numberSeries: Int? = null,
        @OneToMany(mappedBy = "refGymEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refGymHasUserEntities: List<GymHasUserEntity>? = null,
        @OneToMany(mappedBy = "refGymEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
        var refGymHasMachineEntities: List<GymHasMachineEntity>? = null
)
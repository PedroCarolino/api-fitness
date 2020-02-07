package com.app.apiFitness.repository.entity
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Setter
@Getter
@Table(name="gym_has_user")
data class GymHasUserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name="user_id", referencedColumnName = "id")
    var refUserEntity: UserEntity? = null,
    @ManyToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name="gym_id", referencedColumnName = "id")
    var refGymEntity: GymEntity? = null
)
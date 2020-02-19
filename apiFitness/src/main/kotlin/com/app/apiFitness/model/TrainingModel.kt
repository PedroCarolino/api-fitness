package com.app.apiFitness.model

import com.app.apiFitness.database.repository.entity.TrainingEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class TrainingModel(
        var id: Int? = null,
        var name: String? = null,
        @JsonIgnore
        var concentric: String? = null,
        @JsonProperty("restTime")
        var timeBetweenTraining: Int? = null,
        @JsonProperty("observations")
        var obs: String? = null,
        var weight: Int? = null,
        @JsonProperty("sets")
        var series: Int? = null,
        @JsonProperty("repetitions")
        var repetition: Int? = null,
        @JsonIgnore
        var eccentric: Int? = null,
        @JsonIgnore
        var modality: String? = null,
        @JsonIgnore
        var machineId: Int? = null

){
    constructor(trainingEntity: TrainingEntity) : this() {
        this.concentric = trainingEntity.concentric
        this.eccentric = trainingEntity.eccentric
        this.machineId = trainingEntity.machineId
        this.modality = trainingEntity.modality
        this.name = trainingEntity.name
        this.obs = trainingEntity.obs
        this.id = trainingEntity.id?.toInt()
        this.weight = trainingEntity.weight
        this.repetition = trainingEntity.repetition
        this.series = trainingEntity.series
        this.timeBetweenTraining = trainingEntity.timeBetweenTraining?.toInt()
    }
}
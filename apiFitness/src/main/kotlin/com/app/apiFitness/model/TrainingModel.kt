package com.app.apiFitness.model

data class TrainingModel(
        val id: Int? = null,
        val name: String? = null,
        val concentric: String? = null,
        val timeBetweenTraining: String? = null,
        val obs: String? = null,
        val weight: Int? = null,
        val series: Int? = null,
        val repetition: Int? = null,
        val eccentric: Int? = null,
        val modality: String? = null,
        val machineId: Int? = null

)
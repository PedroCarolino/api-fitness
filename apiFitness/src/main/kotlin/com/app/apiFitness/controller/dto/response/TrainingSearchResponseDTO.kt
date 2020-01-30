package com.app.apiFitness.controller.dto.response

import com.app.apiFitness.database.repository.entity.TrainingEntity

data class TrainingSearchResponseDTO(
        var trainings: List<TrainingEntity>? = null
        ): StandardResponseDTO()
package com.app.apiFitness.controller.dto.response

import com.app.apiFitness.model.TrainingModel
import com.app.apiFitness.model.TrainingSheetModel
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class SearchTrainingSheetDetailResponseDTO(
        var teacher: String = "",
        var id: Long? = null,
        var name: String = "",
        var objective: String? = null,
        @JsonProperty("startDate")
        var dateStart: java.sql.Date? = null,
        @JsonProperty("endDate")
        var dateEnd: java.sql.Date? = null,
        var exercises: List<TrainingModel>? = null
): StandardResponseDTO()
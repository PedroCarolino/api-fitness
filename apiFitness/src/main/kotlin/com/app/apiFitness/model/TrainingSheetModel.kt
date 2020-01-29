package com.app.apiFitness.model

data class TrainingSheetModel (
        val id: Long? = null,
        val name: String? = null,
        val description: String? = null,
        val objective: String? = null,
        val studentId: Int? = null,
        val teacherId: Int? = null,
        val dateStart: java.sql.Date? = null,
        val dateEnd: java.sql.Date? = null
)
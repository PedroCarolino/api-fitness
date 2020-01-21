package com.app.apiFitness.database.repository

import com.app.apiFitness.database.repository.entity.TrainingHasTrainingsheetEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TrainingHasTrainingsheetRepository: JpaRepository<TrainingHasTrainingsheetEntity, Long>
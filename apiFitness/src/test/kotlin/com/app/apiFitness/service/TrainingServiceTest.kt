package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TrainingCreateRequestDTO
import com.app.apiFitness.database.repository.TrainingHasTrainingsheetRepository
import com.app.apiFitness.database.repository.TrainingRepository
import com.app.apiFitness.database.repository.TrainingsheetRepository
import com.app.apiFitness.database.repository.entity.TrainingEntity
import com.app.apiFitness.database.repository.entity.TrainingHasTrainingsheetEntity
import com.app.apiFitness.model.TrainingModel
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import org.springframework.beans.factory.annotation.Autowired

@RunWith(JUnit4::class)
class TrainingServiceTest {

    @InjectMocks
    lateinit var trainingServiceImpl: TrainingServiceImpl

    @Mock
    lateinit var trainingRepository: TrainingRepository

    @Mock
    lateinit var trainingHasTrainingsheetRepository: TrainingHasTrainingsheetRepository

    @Mock
    lateinit var trainingsheetRepository: TrainingsheetRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        //this.trainingServiceImpl = TrainingServiceImpl()
    }

    @Test
    fun fetchUserRepositories_positiveResponse() {
        // Mock API response
        //<editor-fold desc="YOUR REGION NAME">
        var request = TrainingCreateRequestDTO(trainingModel = TrainingModel(),trainingSheetId = 10 )
        var trainingEntity = TrainingEntity(request.trainingModel)
        trainingEntity.id = 10
        var trainingEntity2 = TrainingEntity(request.trainingModel)
        var trTrainingHasTrainingsheetEntity = TrainingHasTrainingsheetEntity()
        trTrainingHasTrainingsheetEntity.orderTraining = "10"
        trTrainingHasTrainingsheetEntity.trainingId = trainingEntity.id!!.toInt()
        trTrainingHasTrainingsheetEntity.trainingSheetId = request.trainingSheetId
        trainingEntity.id = 10
        whenever(trainingRepository.save(refEq(trainingEntity2))).thenReturn(trainingEntity)
        //</editor-fold>
        // Attacch fake observer
        // Verify
        var retorno = this.trainingServiceImpl.create(request)

        verify(trainingHasTrainingsheetRepository).save(refEq(trTrainingHasTrainingsheetEntity))
        verify(trainingRepository).save(refEq(trainingEntity2))
    }
}
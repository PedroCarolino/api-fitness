package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TrainingSheetCreateRequestDTO
import com.app.apiFitness.database.repository.*
import com.app.apiFitness.database.repository.entity.*
import com.app.apiFitness.model.TrainingModel
import com.app.apiFitness.model.TrainingSheetModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TrainingSheetServiceImpl() : TrainingSheetService {

    @Autowired
    private lateinit var trainingsheetRepository: TrainingsheetRepository

    @Autowired
    private lateinit var trainingRepository: TrainingRepository

    @Autowired
    private lateinit var trainingHasTrainingsheetRepository: TrainingHasTrainingsheetRepository

    override fun create(trainingSheetDTO: TrainingSheetCreateRequestDTO) {
        val trainingSheetId =  createTrainingSheet(trainingSheetDTO.trainingSheetModel).id
        val trainingId =  createTraining(trainingSheetDTO.trainingModel).id
        createTrainingHasTrainingsheet(trainingSheetId,trainingId,"10")
    }
    private fun createTrainingSheet(trainingSheet: TrainingSheetModel) :TrainingsheetEntity{
        var trainingsheetEntity = TrainingsheetEntity(trainingSheet);
        return trainingsheetRepository.save(trainingsheetEntity)
    }
    private fun createTraining(training: TrainingModel):TrainingEntity {
        var trainingEntity = TrainingEntity(training);
        return trainingRepository.save(trainingEntity)
    }

    private fun createTrainingHasTrainingsheet(trainingSheetId: Int?,trainingId: Long?,orderTraining: String?):TrainingHasTrainingsheetEntity {
        var trainingHasTrainingsheetEntity = TrainingHasTrainingsheetEntity();
        trainingHasTrainingsheetEntity.orderTraining = orderTraining
        trainingHasTrainingsheetEntity.trainingId = trainingId?.toInt()
        trainingHasTrainingsheetEntity.trainingSheetId = trainingSheetId
        return trainingHasTrainingsheetRepository.save(trainingHasTrainingsheetEntity)
    }

    override fun searchAllTrainingSheets(id: Long?) {
//        SELECT id_fichaTreino FROM fichaTreino WHERE professorId = 3


    }


}
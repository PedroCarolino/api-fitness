package com.app.apiFitness.service

import com.app.apiFitness.constants.BusinessExceptionMessages
import com.app.apiFitness.controller.dto.request.ChangeTrainingSheetRequestDTO
import com.app.apiFitness.controller.dto.request.TrainingSheetCreateRequestDTO
import com.app.apiFitness.database.repository.*
import com.app.apiFitness.database.repository.entity.*
import com.app.apiFitness.exceptions.BusinessException
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
        if(trainingsheetRepository.findByName(trainingSheetDTO.trainingSheetModel.name) != null){
            saveTrainingSheet(trainingSheetDTO.trainingSheetModel)
        }
        else{
            throw BusinessException(BusinessExceptionMessages.NOME_FICHA_UTILIZADO)
        }

    }
    private fun saveTrainingSheet(trainingSheet: TrainingSheetModel) :TrainingsheetEntity{
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

    override fun change(changeTrainingSheetRequestDTO: ChangeTrainingSheetRequestDTO) {
            saveTrainingSheet(changeTrainingSheetRequestDTO.trainingSheetModel)
    }

}
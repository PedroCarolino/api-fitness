package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TrainingSheetCreateRequestDTO
import com.app.apiFitness.controller.dto.request.UserRequestDTO
import com.app.apiFitness.database.repository.*
import com.app.apiFitness.database.repository.entity.*
import com.app.apiFitness.exceptions.BusinessException
import com.app.apiFitness.model.TrainingModel
import com.app.apiFitness.model.TrainingSheetModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Required
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import javax.persistence.NonUniqueResultException

@Service
class TrainingsheetServiceImpl {

    @Autowired
    private lateinit var trainingsheetRepository: TrainingsheetRepository

    @Autowired
    private lateinit var trainingRepository: TrainingRepository

    @Autowired
    private lateinit var trainingHasTrainingsheetRepository: TrainingHasTrainingsheetRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    fun create(trainingSheetDTO: TrainingSheetCreateRequestDTO) {
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

    private fun createTrainingHasTrainingsheet(trainingSheetId: Int?,trainingId: Int?,orderTraining: String?):TrainingHasTrainingsheetEntity {
        var trainingHasTrainingsheetEntity = TrainingHasTrainingsheetEntity();
        trainingHasTrainingsheetEntity.orderTraining = orderTraining
        trainingHasTrainingsheetEntity.trainingId = trainingId
        trainingHasTrainingsheetEntity.trainingSheetId = trainingSheetId
        return trainingHasTrainingsheetRepository.save(trainingHasTrainingsheetEntity)
    }
}
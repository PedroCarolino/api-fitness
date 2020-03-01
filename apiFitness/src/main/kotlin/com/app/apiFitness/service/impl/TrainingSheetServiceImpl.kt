package com.app.apiFitness.service

import com.app.apiFitness.constants.BusinessExceptionMessages
import com.app.apiFitness.controller.dto.request.ChangeTrainingSheetRequestDTO
import com.app.apiFitness.controller.dto.request.TrainingSheetCreateRequestDTO
import com.app.apiFitness.controller.dto.response.SearchTrainingSheetDetailResponseDTO
import com.app.apiFitness.controller.dto.response.SearchTrainingSheetResponseDTO
import com.app.apiFitness.database.repository.*
import com.app.apiFitness.database.repository.entity.*
import com.app.apiFitness.exceptions.BusinessException
import com.app.apiFitness.model.TrainingModel
import com.app.apiFitness.model.TrainingSheetModel
import com.app.apiFitness.model.UserProfileModel
import org.hibernate.Hibernate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TrainingSheetServiceImpl() : TrainingSheetService {

    @Autowired
    private lateinit var trainingsheetRepository: TrainingsheetRepository

    @Autowired
    private lateinit var trainingRepository: TrainingRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var trainingHasTrainingsheetRepository: TrainingHasTrainingsheetRepository

    override fun create(trainingSheetDTO: TrainingSheetCreateRequestDTO) {
        if(trainingsheetRepository.findByName(trainingSheetDTO.trainingSheetModel.name) == null){
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

    private fun createTrainingHasTrainingsheet(trainingSheetId: Long?,trainingId: Long?,orderTraining: String?):TrainingHasTrainingsheetEntity {
        var trainingHasTrainingsheetEntity = TrainingHasTrainingsheetEntity();
        trainingHasTrainingsheetEntity.orderTraining = orderTraining
        trainingHasTrainingsheetEntity.trainingId = trainingId
        trainingHasTrainingsheetEntity.trainingSheetId = trainingSheetId
        return trainingHasTrainingsheetRepository.save(trainingHasTrainingsheetEntity)
    }

    override fun searchAllTrainingSheetsFromTeacher(id: Long): SearchTrainingSheetResponseDTO {
//        SELECT id_fichaTreino FROM fichaTreino WHERE professorId = 3
        var userResponse = userRepository.findById(id)
        var response = SearchTrainingSheetResponseDTO()
        if(userResponse.isEmpty){
            throw  BusinessException("Nenhum professor encontrado")
        }
        else{
            response.trainingSheets= userResponse.get().refTeacherEntities?.refTrainingsheetEntities?.stream()?.map { x->
                TrainingSheetModel(x, x.refTrainingHasTrainingsheetEntities!!.size.toLong())
            }?.collect(Collectors.toList());
            response.size = response.trainingSheets?.size?.toLong()!!
            response.teacher = userResponse.get().name!!
        }
        return response

    }

    override fun searchAllTrainingSheetsFromStudent(id: Long): SearchTrainingSheetResponseDTO {
//        SELECT id_fichaTreino FROM fichaTreino WHERE professorId = 3
        var userResponse = userRepository.findById(id)
        var response = SearchTrainingSheetResponseDTO()
        if(userResponse.isEmpty){
            throw  BusinessException("Nenhum aluno encontrado")
        }
        else{
            response.trainingSheets= userResponse.get().refStudentEntities?.refTrainingsheetEntities?.stream()?.map { x->
                TrainingSheetModel(x, x.refTrainingHasTrainingsheetEntities!!.size.toLong())
            }?.collect(Collectors.toList());
            response.size = response.trainingSheets?.size?.toLong()!!
            response.teacher = userResponse.get().refStudentEntities?.refTeacherHasStudentEntities?.stream()
                    ?.map { x-> Hibernate.unproxy(Hibernate.unproxy(x.refTeacherEntity,TeacherEntity::class.java).
                            refUserEntity,UserEntity::class.java).name }?.collect(Collectors.toList())?.first()!!

        }
        return response

    }

    override fun searchTrainingSheets(id: Long): SearchTrainingSheetDetailResponseDTO {
//        SELECT id_fichaTreino FROM fichaTreino WHERE professorId = 3
        var trainingsheet = trainingsheetRepository.findById(id)
        var response = SearchTrainingSheetDetailResponseDTO()
        if(trainingsheet ==null){
            throw  BusinessException("Nenhuma ficha encontrada")
        }
        else{
            response.dateEnd = trainingsheet.get().dateEnd
            response.dateStart = trainingsheet.get().dateStart
            response.objective = trainingsheet.get().objective
            response.id = trainingsheet.get().id
            response.name = trainingsheet.get().name
            response.teacher = Hibernate.unproxy(Hibernate.unproxy(trainingsheet.get().refTeacherEntity,TeacherEntity::class.java).refUserEntity,UserEntity::class.java).name!!
            response.exercises = trainingsheet.get().refTrainingHasTrainingsheetEntities?.stream()
                    ?.map { x-> TrainingModel( Hibernate.unproxy(x.refTrainingEntity,TrainingEntity::class.java)) }?.collect(Collectors.toList());
        }

        return response

    }

    override fun change(changeTrainingSheetRequestDTO: ChangeTrainingSheetRequestDTO) {
            saveTrainingSheet(changeTrainingSheetRequestDTO.trainingSheetModel)
    }

}
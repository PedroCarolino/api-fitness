package com.app.apiFitness.controller

import com.app.apiFitness.constants.ReturnMessages
import com.app.apiFitness.controller.dto.request.TrainingSheetCreateRequestDTO
import com.app.apiFitness.controller.dto.response.StandardReturnDTO
import com.app.apiFitness.exceptions.BusinessException
import com.app.apiFitness.service.TrainingsheetServiceImpl
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/createSheet")
class TrainingsheetController {
    private val logger = Logger.getLogger(javaClass)
    @Autowired
    private lateinit var trainingsheetServiceImpl: TrainingsheetServiceImpl

    @PostMapping
    fun signup(@RequestBody trainingSheetCreateRequestDTO: TrainingSheetCreateRequestDTO): ResponseEntity<StandardReturnDTO> {
        try {
            trainingsheetServiceImpl.create(trainingSheetCreateRequestDTO)
        }
        catch (ex : BusinessException){
            logger.error(ex.message,ex)
            return ResponseEntity.unprocessableEntity().body(StandardReturnDTO(2,ex.message))
        }
        catch (ex : Exception){
            logger.error(ex.message,ex)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(StandardReturnDTO(1, ReturnMessages.INTERNAL_SERVER_ERROR))
        }

        return ResponseEntity.created(URI("")).body(StandardReturnDTO(0,""))
    }
}
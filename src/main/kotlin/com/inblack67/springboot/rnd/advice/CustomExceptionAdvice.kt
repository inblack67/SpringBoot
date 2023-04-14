package com.inblack67.springboot.rnd.advice

import com.inblack67.springboot.rnd.exceptions.CustomException
import com.inblack67.springboot.rnd.utils.CustomExceptionModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionAdvice {
    @ExceptionHandler(CustomException::class)
    fun handleCustomException(ex: CustomException): ResponseEntity<CustomExceptionModel> {
        return ResponseEntity(
            CustomExceptionModel(ex.message.toString() + " * ${ex.customCode}", HttpStatus.BAD_REQUEST),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleReqBodyValidationException(ex: MethodArgumentNotValidException): ResponseEntity<CustomExceptionModel> {
        return ResponseEntity(
            CustomExceptionModel(ex.fieldError?.defaultMessage.toString(), HttpStatus.BAD_REQUEST),
            HttpStatus.BAD_REQUEST
        )
    }
}
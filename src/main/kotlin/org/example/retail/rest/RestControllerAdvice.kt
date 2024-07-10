package org.example.retail.rest

import org.example.retail.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    suspend fun handleNotFoundException(e: NotFoundException): ResponseEntity<Any> {
        return ResponseEntity(
            e.message, HttpStatus.NOT_FOUND
        )
    }
}
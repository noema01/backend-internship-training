package net.noema.inventory.rest

import net.noema.inventory.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    suspend fun handleNotFoundException(e: NotFoundException): ResponseEntity<Any> {
        return ResponseEntity(
            e.message, HttpStatus.NOT_FOUND
        )
    }
}
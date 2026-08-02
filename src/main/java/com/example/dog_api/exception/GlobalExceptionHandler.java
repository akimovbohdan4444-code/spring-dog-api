package com.example.dog_api.exception;

// Повертає JSON.
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Обробляє Exception.
import org.springframework.web.bind.annotation.ExceptionHandler;

// HTTP-статус.
import org.springframework.http.HttpStatus;

// HTTP-відповідь.
import org.springframework.http.ResponseEntity;
// Validation Exception.
import org.springframework.web.bind.MethodArgumentNotValidException;

// Для отримання повідомлень про помилки.
import org.springframework.validation.FieldError;
import com.example.dog_api.dto.ErrorResponse;
// Позначає клас як глобальний обробник помилок.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Якщо виникла Validation-помилка.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(

            MethodArgumentNotValidException exception) {

        // Беремо першу помилку.
        FieldError error = exception
                .getBindingResult()
                .getFieldError();

        // Створюємо DTO.
        ErrorResponse response = new ErrorResponse();

        // Записуємо текст помилки.
        response.setMessage(error.getDefaultMessage());

        // Повертаємо JSON.
        return ResponseEntity
                .badRequest()
                .body(response);

    }
}
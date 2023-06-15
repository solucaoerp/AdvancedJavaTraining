package com.ibrplanner.customers.controllers.handlers;

import com.ibrplanner.customers.dtos.exceptions.ApiErrorDTO;
import com.ibrplanner.customers.dtos.exceptions.ValidationApiErrorDTO;
import com.ibrplanner.customers.services.exceptions.DatabaseServiceException;
import com.ibrplanner.customers.services.exceptions.ResourceNotFoundServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

/**
 * Classe responsável por manipular e tratar as exceções lançadas pelos controladores.
 * Esta classe captura exceções específicas e retorna uma resposta HTTP apropriada com detalhes sobre o erro.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Manipula exceções de recursos não encontrados.
     *
     * @param e a exceção lançada
     * @param request a requisição HTTP que causou a exceção
     * @return uma resposta HTTP contendo os detalhes do erro
     */
    @ExceptionHandler(ResourceNotFoundServiceException.class)
    public ResponseEntity<ApiErrorDTO> resourceNotFound(ResourceNotFoundServiceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiErrorDTO err = new ApiErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    /**
     * Manipula exceções do banco de dados.
     *
     * @param e a exceção lançada
     * @param request a requisição HTTP que causou a exceção
     * @return uma resposta HTTP contendo os detalhes do erro
     */
    @ExceptionHandler(DatabaseServiceException.class)
    public ResponseEntity<ApiErrorDTO> database(DatabaseServiceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiErrorDTO err = new ApiErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    /**
     * Manipula exceções de validação de argumentos de métodos.
     *
     * @param e a exceção lançada
     * @param request a requisição HTTP que causou a exceção
     * @return uma resposta HTTP contendo os detalhes do erro
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationApiErrorDTO err = new ValidationApiErrorDTO(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }
}
package com.ibrplanner.customers.dtos.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por modelar o objeto de erro de validação retornado nas requisições da API.
 * Esta classe estende ApiErrorDTO, adicionando uma lista de FieldErrorDTO que contém detalhes sobre os campos específicos que causaram a exceção.
 */
public class ValidationApiErrorDTO extends ApiErrorDTO {

    private List<FieldErrorDTO> errors = new ArrayList<>();

    /**
     * Cria uma nova instância de ValidationApiErrorDTO.
     *
     * @param timestamp o timestamp da ocorrência do erro
     * @param status o status HTTP relacionado ao erro
     * @param error a mensagem de erro principal
     * @param path o caminho da requisição que causou o erro
     */
    public ValidationApiErrorDTO(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    /**
     * Retorna a lista de erros de campo associada a esta instância.
     *
     * @return a lista de erros de campo
     */
    public List<FieldErrorDTO> getErrors() {
        return errors;
    }

    /**
     * Adiciona um novo erro de campo à lista de erros.
     *
     * @param fieldName o nome do campo que causou o erro
     * @param message a mensagem de erro associada ao campo
     */
    public void addError(String fieldName, String message) {
        errors.add(new FieldErrorDTO(fieldName, message));
    }
}
package com.ibrplanner.customers.dtos.exceptions;

/**
 * Classe responsável por modelar o objeto de erro de campo retornado nas requisições da API.
 * Esta classe contém detalhes sobre o campo específico que causou a exceção, como o nome do campo e a mensagem de erro associada.
 */
public class FieldErrorDTO {

    private String fieldName;
    private String message;

    /**
     * Cria uma nova instância de FieldErrorDTO.
     *
     * @param fieldName o nome do campo que causou a exceção
     * @param message a mensagem de erro associada ao campo
     */
    public FieldErrorDTO(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    /**
     * Retorna o nome do campo que causou a exceção.
     *
     * @return o nome do campo
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Retorna a mensagem de erro associada ao campo.
     *
     * @return a mensagem de erro
     */
    public String getMessage() {
        return message;
    }
}

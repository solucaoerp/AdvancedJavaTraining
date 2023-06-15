package com.ibrplanner.customers.dtos.exceptions;

import java.time.Instant;

/**
 * Classe responsável por modelar o objeto de erro retornado nas requisições da API.
 * Esta classe contém detalhes sobre a exceção que ocorreu, como o momento em que aconteceu (timestamp),
 * o status HTTP da resposta, a mensagem de erro e o caminho da requisição que causou a exceção.
 */
public class ApiErrorDTO {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    /**
     * Cria uma nova instância de ApiErrorDTO.
     *
     * @param timestamp o momento em que a exceção ocorreu
     * @param status o status HTTP da resposta
     * @param error a mensagem de erro
     * @param path o caminho da requisição que causou a exceção
     */
    public ApiErrorDTO(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    /**
     * Retorna o momento em que a exceção ocorreu.
     *
     * @return o momento em que a exceção ocorreu
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * Retorna o status HTTP da resposta.
     *
     * @return o status HTTP da resposta
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Retorna a mensagem de erro.
     *
     * @return a mensagem de erro
     */
    public String getError() {
        return error;
    }

    /**
     * Retorna o caminho da requisição que causou a exceção.
     *
     * @return o caminho da requisição que causou a exceção
     */
    public String getPath() {
        return path;
    }
}
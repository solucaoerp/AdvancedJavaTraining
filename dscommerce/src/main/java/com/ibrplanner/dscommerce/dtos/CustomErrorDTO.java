package com.ibrplanner.dscommerce.dtos;

import java.time.Instant;

public class CustomErrorDTO {

    /* Destinado a customização do erro retornado nas requisições (Mensagem Padrão nas Requisições
     * A classe 'ControllerExceptionHandler' usa e trata o retorno.
     */

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomErrorDTO(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}

package com.ibrplanner.customers.services.exceptions;

/**
 * Classe responsável por encapsular exceções específicas relacionadas a operações de banco de dados em camada de serviço.
 * Esta classe estende a RuntimeException, o que significa que não é necessário um bloco try-catch para lidar com essa exceção.
 */
public class DatabaseServiceException extends RuntimeException {

    /**
     * Cria uma nova instância de DatabaseServiceException com a mensagem de erro especificada.
     *
     * @param msg a mensagem de erro associada a esta exceção
     */
    public DatabaseServiceException(String msg) {
        super(msg);
    }
}
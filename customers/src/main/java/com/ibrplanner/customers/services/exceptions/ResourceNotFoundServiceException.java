package com.ibrplanner.customers.services.exceptions;

/**
 * Classe responsável por encapsular exceções específicas relacionadas à busca de recursos em camada de serviço que não foram encontrados.
 * Esta classe estende a RuntimeException, o que significa que não é necessário um bloco try-catch para lidar com essa exceção.
 */
public class ResourceNotFoundServiceException extends RuntimeException {

    /**
     * Cria uma nova instância de ResourceNotFoundServiceException com a mensagem de erro especificada.
     *
     * @param msg a mensagem de erro associada a esta exceção
     */
    public ResourceNotFoundServiceException(String msg) {
        super(msg);
    }
}
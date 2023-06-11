package com.ibrplanner.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    /*
     * Quando nao encontrar o recurso procurado
     * RuntimeException: Dispensa o Try-Catch
     */

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}

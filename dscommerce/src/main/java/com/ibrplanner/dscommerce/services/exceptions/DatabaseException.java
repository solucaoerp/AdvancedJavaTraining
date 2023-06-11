package com.ibrplanner.dscommerce.services.exceptions;

public class DatabaseException extends RuntimeException {
    /*
     * Quando nao encontrar o recurso procurado
     * RuntimeException: Dispensa o Try-Catch
     */

    public DatabaseException(String msg) {
        super(msg);
    }
}

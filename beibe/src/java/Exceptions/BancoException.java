/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Bruno Fernandes
 */
public class BancoException extends AppException {

    /**
     * Creates a new instance of <code>BancoException</code> without detail
     * message.
     */
    public BancoException() {
    }

    /**
     * Constructs an instance of <code>BancoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BancoException(String msg) {
        super(msg);
    }
}

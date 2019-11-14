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
public class ErroCliente extends AppException {

    /**
     * Creates a new instance of <code>ErroCliente</code> without detail
     * message.
     */
    public ErroCliente() {
    }

    /**
     * Constructs an instance of <code>ErroCliente</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErroCliente(String msg) {
        super(msg);
    }
}

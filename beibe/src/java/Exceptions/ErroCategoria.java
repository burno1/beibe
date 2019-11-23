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
public class ErroCategoria extends AppException {

    /**
     * Creates a new instance of <code>ErroCategoria</code> without detail
     * message.
     */
    public ErroCategoria() {
    }

    /**
     * Constructs an instance of <code>ErroCategoria</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErroCategoria(String msg) {
        super(msg);
    }
}

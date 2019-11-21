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
public class ErroFuncionario extends AppException {

    /**
     * Creates a new instance of <code>ErroFuncionario</code> without detail
     * message.
     */
    public ErroFuncionario() {
    }

    /**
     * Constructs an instance of <code>ErroFuncionario</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErroFuncionario(String msg) {
        super(msg);
    }
}

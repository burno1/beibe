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
public class ErroAtendimento extends AppException {

    /**
     * Creates a new instance of <code>ErroAtendimento</code> without detail
     * message.
     */
    public ErroAtendimento() {
    }

    /**
     * Constructs an instance of <code>ErroAtendimento</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErroAtendimento(String msg) {
        super(msg);
    }
}

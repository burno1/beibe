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
public class ErroProduto extends AppException {

    /**
     * Creates a new instance of <code>ErroProduto</code> without detail
     * message.
     */
    public ErroProduto() {
    }

    /**
     * Constructs an instance of <code>ErroProduto</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErroProduto(String msg) {
        super(msg);
    }
}

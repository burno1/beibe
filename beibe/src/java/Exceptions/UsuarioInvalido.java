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
public class UsuarioInvalido extends AppException {

    /**
     * Creates a new instance of <code>UsuarioInvalido</code> without detail
     * message.
     */
    public UsuarioInvalido() {
        super("Usuario ou Senha Inválidos");
    }

    /**
     * Constructs an instance of <code>UsuarioInvalido</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioInvalido(String msg) {
        super(msg);
    }
}

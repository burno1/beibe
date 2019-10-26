/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Facade.UsuarioService;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class PortalBean {

    List<Usuario> listaUsuarios = null;
    UsuarioService usuarioService = new UsuarioService();

    public PortalBean() {

    }

    public List<Usuario> getListaUsuarios() {
        return usuarioService.listar();
    }
}

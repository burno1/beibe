/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class PortalBean {

    List<Usuario> usuariosBanco = null;

    public PortalBean() {
//        usuariosBanco = new UsuarioDAO().buscarTodos();
    }

    public List<Usuario> getUsuariosBanco() {
        return usuariosBanco = new UsuarioDAO().buscarTodos();
    }

    public void setUsuariosBanco(List<Usuario> usuariosBanco) {
        this.usuariosBanco = usuariosBanco;
    }

}

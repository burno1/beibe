/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Facade.LoginService;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class PortalBean {

    List<Usuario> listaUsuarios = null;
    LoginService loginService = new LoginService();

    public PortalBean() {

    }

    public List<Usuario> getListaUsuarios() {
        return loginService.listar();
    }
}

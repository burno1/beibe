/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Facade.LoginService;
import Model.Funcionario;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class PortalBean {

    List<Funcionario> listaFuncionarios = null;
    LoginService loginService = new LoginService();

    public PortalBean() {

    }

    public List<Funcionario> getListaFuncionarios() {
        return loginService.listar();
    }
}

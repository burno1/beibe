/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClienteDAO;
import Model.Cliente;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class ClienteBean {
        List<Cliente> listaClientes = null;
        private String idCliente;

    public ClienteBean() {
//        usuariosBanco = new UsuarioDAO().buscarTodos();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes = new ClienteDAO().buscarTodos();
    }

    public void setListaClientes(List<Cliente> clientesBanco) {
        this.listaClientes = clientesBanco;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}

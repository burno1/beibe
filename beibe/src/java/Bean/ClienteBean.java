/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Model.Cliente;
import Model.Produto;
import java.text.ParseException;
import java.util.List;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Erick Alessi
 */
public class ClienteBean {

    List<Cliente> listaClientes = null;
    private String idCliente = "1";

    public ClienteBean() {
    }

    public List<Cliente> getListaClientes() {

        for (Cliente cliente : listaClientes) {
            try {
                MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
                mascaraCpf.setValueContainsLiteralCharacters(false);
                cliente.setCpf(mascaraCpf.valueToString(cliente.getCpf()));
            } catch (ParseException ex) {
            }
        }

        return listaClientes;
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

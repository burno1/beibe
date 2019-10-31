
import DAO.CidadeDAO;
import DAO.EstadoDAO;
import Factories.ConnectionFactory;
import Model.Cidade;
import Model.Cliente;
import Model.Estado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Erick Alessi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CidadeDAO cidadeDAO = new CidadeDAO();
//        System.out.println(cidade.buscarCidadeId(1).getNome());
        EstadoDAO estadoDAO = new EstadoDAO();
//        for (Estado e : estadoDAO.listarTodosEstados()) {
//            System.out.println(e.getNome() + " " + e.getUf());
//            for (Cidade c : cidadeDAO.buscarTodosPorEstado(e)) {
//                System.out.println("        " + c.getNome() + " " + c.getEstado().getUf());
//            }
//        }
        Cliente cliente = new Cliente();
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        cidade.setNome("curitiba");
        estado.setUf("pr");
        cliente.setCidade(cidade);
        cidade.setEstado(estado);
        System.out.println(cidadeDAO.buscarIdCidade(cliente.getCidade()));
        System.out.println(estadoDAO.buscarIdEstado(cliente.getCidade().getEstado()));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.CidadeDAO;
import Model.Cidade;
import Model.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class CidadeService {

    CidadeDAO cidadeDAO = new CidadeDAO();

    public Cidade buscarPorId(int id) {
        Cidade retorno = new Cidade();

        retorno = cidadeDAO.buscarCidadePorId(id);
        return retorno;
    }

    public List<Cidade> buscarPorEstado(Estado estado) {
        List<Cidade> retorno = new ArrayList<Cidade>();

        retorno = cidadeDAO.buscarTodosPorEstado(estado);

        return retorno;
    }

}

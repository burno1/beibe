/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.AtendimentoDAO;
import Model.TipoAtendimento;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class TipoAtendimentoService {

    AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

    public List<TipoAtendimento> buscaTipo() {
        return atendimentoDAO.buscaPorTipo();
    }


}

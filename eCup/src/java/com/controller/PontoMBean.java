/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.controller;

import com.dao.PontoDAO;
import com.model.Ponto;
import com.util.Utils;
import java.io.Serializable;

/**
 *
 * @author mariana
 */
public class PontoMBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Ponto ponto;
    private final PontoDAO pontoDAO = new PontoDAO();
    
    public Ponto getPonto(){
        return ponto;
    }
    
    public void onPageLoad(){
        ponto = new Ponto();
    }
    
    public String criar()  {
        if (!Utils.isNullOrEmpty(ponto.getDescricao()) || Utils.isNullOrEmpty(ponto.getValor())) {
            try {
                pontoDAO.salvar(ponto);
            } catch (Exception e) {
                System.err.println("Não foi possível inserir pontuação." + e);
            }
        }
        
        return "pontuaçãoCriada";
    }
}

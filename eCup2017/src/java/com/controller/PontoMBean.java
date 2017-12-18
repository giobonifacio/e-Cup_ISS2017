/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.PontoDAO;
import com.model.Ponto;
import com.util.SessionUtils;
import com.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariana
 */
public class PontoMBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Ponto ponto;
    private final PontoDAO pontoDAO = new PontoDAO();
    private List<Ponto> pontos = new ArrayList<>();
    
    public Ponto getPonto() {
        return ponto;
    }
    
    public void onPageLoad(){
        carregaListaPontos();
        ponto = new Ponto();
    }
      
    public void onPageLoadCriarPonto() {
        if (ponto == null) {
             ponto = new Ponto();
        }
    }
    
    public String criar()  {
        if (Utils.isNullOrEmpty(ponto.getDescricao()))
             return "erro";
                
         try {
                if (ponto.getId() == null) {
                    pontoDAO.salvar(ponto);
                }
                else
                    pontoDAO.alterar(ponto);
                return goToPageControlePonto();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
    
    public String goToPageRemoverPonto() {
        return "excluirPonto";
    }
    
    public String goToPageEditarPonto() {
        return "editarPonto";
    }
    
    public String goToPageControlePonto() {
    return "index";
    }

    public void carregaListaPontos() {
        setPontos(pontoDAO.listAll());
    }
    
    public String removePonto(Ponto user) {
        pontoDAO.excluir(user);
        return "index";
    }
    
    public String goToPageCriarPonto() {
        this.ponto = null;
        return "criarPonto";
    }
    
    public String goToPageEditarPonto(Ponto user) {
        this.ponto = user;
        return "criarPonto";
    }
        
    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> usuarios) {
        this.pontos = usuarios;
    }
    
    public String getLabelPagina() {
        if (ponto.getId() == null) {
            return "Criar nova pontuação";
        }
        
        return "Edite a pontuação";
    }
}
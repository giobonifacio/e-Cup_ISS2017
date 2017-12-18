/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.PunicaoDAO;
import com.model.Punicao;
import com.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariana
 */
public class PunicaoMBean implements Serializable{
     private static final long serialVersionUID = 1L;
     private Punicao punicao;
     private final PunicaoDAO punicaoDAO = new PunicaoDAO();
     private List<Punicao> punicoes = new ArrayList<>();
    
    public Punicao getPunicao() {
        return punicao;
    }
    
    public void onPageLoad(){
        carregaListaPunicoes();
        punicao = new Punicao();
    }
      
    public void onPageLoadCriarPunicao() {
        if (punicao == null) {
             punicao = new Punicao();
        }
    }
    
    public String criar()  {
        if (Utils.isNullOrEmpty(punicao.getDescricao()))
             return "erro";
                
         try {
                if (punicao.getId() == null) {
                    punicaoDAO.salvar(punicao);
                }
                else
                    punicaoDAO.alterar(punicao);
                return goToPageControlePunicao();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
    
    public String goToPageRemoverPunicao() {
        return "excluirPunicao";
    }
    
    public String goToPageEditarPunicao() {
        return "editarPunicao";
    }
    
    public String goToPageControlePunicao() {
    return "index";
    }

    public void carregaListaPunicoes() {
        setPunicoes(punicaoDAO.listAll());
    }
    
    public String removePunicao(Punicao user) {
        punicaoDAO.excluir(user);
        return "index";
    }
    
    public String goToPageCriarPunicao() {
        this.punicao = null;
        return "criarPunicao";
    }
    
    public String goToPageEditarPunicao(Punicao user) {
        this.punicao = user;
        return "criarPunicao";
    }
        
    public List<Punicao> getPunicoes() {
        return punicoes;
    }

    public void setPunicoes(List<Punicao> punicoes) {
        this.punicoes = punicoes;
    }
    
    public String getLabelPagina() {
        if (punicao.getId() == null) {
            return "Criar nova punição";
        }
        
        return "Edite a punição";
    }
}

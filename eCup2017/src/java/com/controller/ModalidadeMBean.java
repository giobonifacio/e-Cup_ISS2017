/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ModalidadeDAO;
import com.model.Modalidade;
import com.model.Tempo;
import com.util.SessionUtils;
import com.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mariana
 */
public class ModalidadeMBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Modalidade modalidade;
    private final ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
    private List<Modalidade> modalidades = new ArrayList<>();
    
    public Modalidade getModalidade(){
        return modalidade;
    }
    
    public void onPageLoad(){
        carregaListaModalidades();
        modalidade = new Modalidade();
    }
    
     public void onPageLoadCriarModalidade() {
        if (modalidade == null) {
             modalidade = new Modalidade();
        }
    }
     
    public String criar()  {
        if (false) {
            return "erro";
        }
        
         try {
                if (modalidade.getId() == null) {
                    modalidadeDAO.salvar(modalidade);
                    String usuarioLogado = SessionUtils.getUserName();
                    if (Utils.isNullOrEmpty(usuarioLogado)) 
                         return "login";
                }
                else
                    modalidadeDAO.alterar(modalidade);
                return goToPageControleModalidade();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
    
    public String goToPageControleModalidade() {
    return "usuarios";
    }

    public void carregaListaModalidades() {
        setModalidades(modalidadeDAO.listAll());
    }
    
    public String removeRegulamento(Modalidade user) {
        modalidadeDAO.excluir(user);
        return "index";
    }
    
    public String goToPageCriarModalidade() {
        this.modalidade = null;
        return "criarModalidade";
    }
    
    public String goToPageEditarModalidade(Modalidade user) {
        this.modalidade = user;
        return "criarModalidade";
    }
    
    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }
    
    public String getLabelPagina() {
        if (modalidade.getId() == null) {
            return "Criar nova modalidade";
        }
        
        return "Edite a modalidade";
    }
    
    public List<Tempo> getTodosTempos() {
        return Arrays.asList();
    }
}

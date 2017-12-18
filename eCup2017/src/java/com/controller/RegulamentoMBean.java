package com.controller;


import com.dao.RegulamentoDAO;
import com.model.Modalidade;
import com.model.Ponto;
import com.model.Punicao;
import com.model.Regulamento;
import com.model.Tempo;
import com.util.SessionUtils;
import com.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovane
 */
@ManagedBean
@SessionScoped
public class RegulamentoMBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Regulamento regulamento;
    private final RegulamentoDAO regulamentoDAO = new RegulamentoDAO();
    private List<Regulamento> regulamentos = new ArrayList<>();
    
    
    public Regulamento getRegulamento() {
        return regulamento;
    }
    
    public void onPageLoad(){
        carregaListaRegulamentos();
        regulamento = new Regulamento();
    }
      
    public void onPageLoadCriarRegulamento() {
        if (regulamento == null) {
             regulamento = new Regulamento();
        }
    }
    
    public String criar()  {
        
         if (Utils.isNullOrEmpty(pessoa.getNome()))
             return "erro";
        
         try {
                if (regulamento.getId() == null) {
                    regulamentoDAO.salvar(regulamento);
                }
                else
                    regulamentoDAO.alterar(regulamento);
                return goToPageControleRegulamento();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir regulamento." + e);
            }
       return "erro";
    }
    
    public String goToPageControleRegulamento() {
    return "usuarios";
    }

    public void carregaListaRegulamentos() {
        setRegulamentos(regulamentoDAO.listAll());
    }
    
    public String removeRegulamento(Regulamento user) {
        regulamentoDAO.excluir(user);
        return "index";
    }
    
    public String goToPageCriarRegulamento() {
        this.regulamento = null;
        return "criarRegulamento";
    }
    
    public String goToPageEditarRegulamento(Regulamento user) {
        this.regulamento = user;
        return "criarRegulamento";
    }
    
        
    /**
     * @return the usuarios
     */
    public List<Regulamento> getRegulamentos() {
        return regulamentos;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setRegulamentos(List<Regulamento> usuarios) {
        this.regulamentos = usuarios;
    }
    
    public String getLabelPagina() {
        if (regulamento.getId() == null) {
            return "Criar novo usuário";
        }
        
        return "Edite o usuário";
    }
    
    
    public List<Modalidade> getTodasModalidades() {
        return Arrays.asList();
    }
    
    public List<Ponto> getTodasPontos() {
        return Arrays.asList();
    }
    
    public List<Punicao> getTodasPunicoes() {
        return Arrays.asList();
    }
    
    public List<Tempo> getTodosTempos() {
        return Arrays.asList();
    }
}

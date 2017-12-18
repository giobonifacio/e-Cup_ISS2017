/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TempoDAO;
import com.model.Tempo;
import com.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mariana
 */
@ManagedBean
@SessionScoped
public class TempoMBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Tempo tempo;
    private final TempoDAO tempoDAO = new TempoDAO();
    private List<Tempo> tempos = new ArrayList<>();
    
    
    public Tempo getTempo() {
        return tempo;
    }
    
    public void onPageLoad(){
        carregaListaTempos();
        tempo = new Tempo();
    }
      
    public void onPageLoadCriarTempo() {
        if (tempo == null) {
             tempo = new Tempo();
        }
    }
    
    public String criar()  {
     
        if (Utils.isNullOrEmpty(tempo.getDescricao()))
             return "erro";
        
         try {
                if (tempo.getId() == null) {
                    tempoDAO.salvar(tempo);
                }
                else
                    tempoDAO.alterar(tempo);
                return goToPageControleTempo();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
    
    public String goToPageRemoverTempo() {
        return "excluirTempo";
    }
    
    public String goToPageEditarTempo() {
        return "editarTempo";
    }
    
    public String goToPageControleTempo() {
    return "index";
    }

    public void carregaListaTempos() {
        setTempos(tempoDAO.listAll());
    }
    
    public String removeTempo(Tempo user) {
        tempoDAO.excluir(user);
        return "index";
    }
    
    public String goToPageCriarTempo() {
        this.tempo = null;
        return "criarTempo";
    }
    
    public String goToPageEditarTempo(Tempo user) {
        this.tempo = user;
        return "criarTempo";
    }
        
    public List<Tempo> getTempos() {
        return tempos;
    }

    public void setTempos(List<Tempo> tempos) {
        this.tempos = tempos;
    }
    
    public String getLabelPagina() {
        if (tempo.getId() == null) {
            return "Criar novo tempo";
        }
        
        return "Edite o tempo";
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *S
 * @author mariana
 */
public class Regulamento implements Serializable{
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)    
    @Column(name = "id")  
    private Integer id;
    @Column(name = "descricao")  
    private String descricao;
    @Column(name = "ponto")
    private Ponto ponto;
    @Column(name = "punicao")
    private Punicao punicao;
    @Column(name = "modalidade")
    private Modalidade modalidade;
    @Column(name = "tempo")
    private Tempo tempo;
  
  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the ponto
     */
    public Ponto getPonto() {
        return ponto;
    }

    /**
     * @param ponto the ponto to set
     */
    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    /**
     * @return the punicao
     */
    public Punicao getPunicao() {
        return punicao;
    }

    /**
     * @param punicao the punicao to set
     */
    public void setPunicao(Punicao punicao) {
        this.punicao = punicao;
    }

    /**
     * @return the modalidade
     */
    public Modalidade getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the tempo
     */
    public Tempo getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

 

    
    
    
}

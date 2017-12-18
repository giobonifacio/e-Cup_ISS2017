/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;
/**
 *
 * @author Ricardo
 */

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
   
@Entity
@Table(name = "equipe")  
public class Equipe implements Serializable{
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)    
    @Column(name = "id") 
    private Integer id;
    @Column(name = "nome") 
    private String nome;
    @Column(name = "modalidade") 
    private String modalidade;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the modalidade
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
    

}

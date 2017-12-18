/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *S
 * @author mariana
 */
@Entity
@Table(name = "modalidade") 
public class Modalidade implements Serializable{
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)    
    @Column(name = "id")  
    private Integer id;
    @Column(name = "nome")  
    private String nome;
    @Column(name = "tempo")
    private Tempo tempo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

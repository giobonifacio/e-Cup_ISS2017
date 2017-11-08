/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author mariana
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ponto") 
public class Ponto implements Serializable{
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)    
    @Column(name = "id")  
    private Integer id;
    @Column(name = "descriçao")  
    private String descricao;
    @Column(name = "valor")  
    private String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;
import javax.persistence.*;  
  
@Entity  
public abstract class IntegranteEquipe extends Pessoa{
    

    @Column(name = "equipe")  
    private Equipe equipe;    
    @Column(name = "funcao")  
    private String funcao;
    
    
    
}

/**
 *
 * @author Ricardo
 */


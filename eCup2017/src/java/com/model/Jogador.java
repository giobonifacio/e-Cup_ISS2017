/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Giovane
 */

import javax.persistence.*;  
  
@Entity  
@DiscriminatorValue("jogador")  
public class Jogador extends IntegranteEquipe{

    @Column(name = "numeracao")  
    private Integer numeracao ;
    
    
    
}

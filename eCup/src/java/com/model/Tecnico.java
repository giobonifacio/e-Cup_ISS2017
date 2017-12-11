/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.model;

/**
 *
 * @author Giovane
 */

import javax.persistence.*;  
  
@Entity  
@DiscriminatorValue("tecnico") 
public class Tecnico extends IntegranteEquipe{
    
}

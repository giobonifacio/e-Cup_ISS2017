/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.controller;

import com.dao.PunicaoDAO;
import com.model.Punicao;
import java.io.Serializable;

/**
 *
 * @author mariana
 */
public class PunicaoMBean implements Serializable{
     private static final long serialVersionUID = 1L;
     private Punicao punicao;
     private final PunicaoDAO punicaoDAO = new PunicaoDAO();
     
     public Punicao getPunicao(){
         return punicao;
     }
     
     public void onPageLoad(){
         punicao = new Punicao();
     }
}

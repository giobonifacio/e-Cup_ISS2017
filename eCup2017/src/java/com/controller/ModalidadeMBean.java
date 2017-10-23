/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ModalidadeDAO;
import com.model.Modalidade;
import java.io.Serializable;

/**
 *
 * @author mariana
 */
public class ModalidadeMBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Modalidade modalidade;
    private final ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
    
    public Modalidade getModalidade(){
        return modalidade;
    }
    
    public void onPageLoad(){
        modalidade = new Modalidade();
    }
}

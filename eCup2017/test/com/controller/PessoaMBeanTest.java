/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giovane
 */
public class PessoaMBeanTest {
    
    
    @Test
    public void testCriar() {
        System.out.println("criar");
        
        PessoaMBean instance = new PessoaMBean();
        instance.onPageLoadCriarPessoa();
        instance.getPessoa().setNome("Giovane");
        instance.getPessoa().setEmail("ra67445@uem.br");
        Integer id = instance.getPessoa().getId();
        String result = instance.criar();
        
        assertEquals("index", result);
    }
    
    
    @Test
    public void testNaoCria() {
        System.out.println("criar");
        
        PessoaMBean instance = new PessoaMBean();
        instance.onPageLoadCriarPessoa();
        instance.getPessoa().setNome("");
        instance.getPessoa().setEmail("ra67445@uem.br");
        Integer id = instance.getPessoa().getId();
        String result = instance.criar();
        
        assertEquals("erro", result);
    }

   
    
}

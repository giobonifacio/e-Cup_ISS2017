/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Tempo;

/**
 *
 * @author mariana
 */
public class TempoMBeanTest {
    @Test
    public void testCriar() {
        System.out.println("criar");
        
        TempoMBean instance = new TempoMBean();
        instance.onPageLoadCriarTempo();
        instance.getTempo().setDescricao("Futebol tempo");
        instance.getTempo().setQtddPeriodo(2);
        Integer id = instance.getTempo().getId();
        String result = instance.criar();
        
        assertEquals("index", result);
    }
    
    
    @Test
    public void testNaoCria() {
        System.out.println("criar");
        
        
        
        TempoMBean instance = new TempoMBean();
        instance.onPageLoadCriarTempo();
        instance.getTempo().setDescricao("Futebol tempo");
        instance.getTempo().setQtddPeriodo(instance.getTempo().getQtddPeriodo());
        Integer id = instance.getTempo().getId();
        String result = instance.criar();
        
        assertEquals("erro", result);
    }
}

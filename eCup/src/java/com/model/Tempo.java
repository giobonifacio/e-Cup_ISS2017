/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tempo")  

/**
 *
 * @author Ricardo
 */
public class Tempo implements Serializable{
       
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)    
    @Column(name = "id") 
    private Integer id;
    @Column(name = "descricao") 
    private String descricao;
    @Column(name = "qtddPeriodo") 
    private Integer qtddPeriodo;
    @Column (name = "duracaoPeriodo")
    private Integer duracaoPeriodo;
    @Column(name = "qtddExtra") 
    private Integer qtddExtra;
    @Column (name = "duracaoExtra")
    private Integer duracaoExtra;
    @Column(name = "qtddTimeout") 
    private Integer qtddTimeout;
    @Column (name = "duracaoTimeout")
    private Integer duracaoTimeout;

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the qtddPeriodo
     */
    public Integer getQtddPeriodo() {
        return qtddPeriodo;
    }

    /**
     * @param qtddPeriodo the qtddPeriodo to set
     */
    public void setQtddPeriodo(Integer qtddPeriodo) {
        this.qtddPeriodo = qtddPeriodo;
    }

    /**
     * @return the duracaoPeriodo
     */
    public Integer getDuracaoPeriodo() {
        return duracaoPeriodo;
    }

    /**
     * @param duracaoPeriodo the duracaoPeriodo to set
     */
    public void setDuracaoPeriodo(Integer duracaoPeriodo) {
        this.duracaoPeriodo = duracaoPeriodo;
    }

    /**
     * @return the qtddExtra
     */
    public Integer getQtddExtra() {
        return qtddExtra;
    }

    /**
     * @param qtddExtra the qtddExtra to set
     */
    public void setQtddExtra(Integer qtddExtra) {
        this.qtddExtra = qtddExtra;
    }

    /**
     * @return the duracaoExtra
     */
    public Integer getDuracaoExtra() {
        return duracaoExtra;
    }

    /**
     * @param duracaoExtra the duracaoExtra to set
     */
    public void setDuracaoExtra(Integer duracaoExtra) {
        this.duracaoExtra = duracaoExtra;
    }

    /**
     * @return the qtddTimeout
     */
    public Integer getQtddTimeout() {
        return qtddTimeout;
    }

    /**
     * @param qtddTimeout the qtddTimeout to set
     */
    public void setQtddTimeout(Integer qtddTimeout) {
        this.qtddTimeout = qtddTimeout;
    }

    /**
     * @return the duracaoTimeout
     */
    public Integer getDuracaoTimeout() {
        return duracaoTimeout;
    }

    /**
     * @param duracaoTimeout the duracaoTimeout to set
     */
    public void setDuracaoTimeout(Integer duracaoTimeout) {
        this.duracaoTimeout = duracaoTimeout;
    }
    
    
    
}

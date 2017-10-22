/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;  

/**
 *
 * @author Giovane
 */

@Entity  
@Table(name = "pessoa")  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="classePessoa",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="pessoa")  
public class Pessoa implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)    
    @Column(name = "id")      
    private Integer id;
    
    @Column(name = "nome")  
    private String nome;
    
    @Column(name = "dataNascimento")  
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "sexo")  
    private String sexo;
    
    @Column(name = "rg")  
    private String rg;
    
    @Column(name = "telefone")  
    private String telefone;
    
    @Column(name = "email")  
    private String email;
    
    @Column(name = "endereco")  
    private String endereco;
            
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}

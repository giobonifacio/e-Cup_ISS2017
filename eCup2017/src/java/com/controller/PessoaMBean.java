package com.controller;


import com.dao.PessoaDAO;
import com.dao.PessoaDAO;
import com.model.Pessoa;
import com.model.Pessoa;
import com.util.SessionUtils;
import com.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovane
 */
@ManagedBean
@SessionScoped
public class PessoaMBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Pessoa pessoa;
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private List<Pessoa> pessoas = new ArrayList<>();
    
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void onPageLoad(){
        carregaListaPessoas();
        pessoa = new Pessoa();
    }
      
    public void onPageLoadCriarPessoa() {
        if (pessoa == null) {
             pessoa = new Pessoa();
        }
    }
    
    public String criar()  {
     
        if (Utils.isNullOrEmpty(pessoa.getNome()))
             return "erro";
        
         try {
                if (pessoa.getId() == null) {
                    pessoaDAO.salvar(pessoa);
                }
                else
                    pessoaDAO.alterar(pessoa);
                return goToPageControlePessoa();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
    
    public String goToPageRemoverPessoa() {
        return "excluirPessoa";
    }
    
    public String goToPageEditarPessoa() {
        return "editarPessoa";
    }
    
    public String goToPageControlePessoa() {
    return "index";
    }

    public void carregaListaPessoas() {
        setPessoas(pessoaDAO.listAll());
    }
    
    public String removePessoa(Pessoa user) {
        pessoaDAO.excluir(user);
        return "index";
    }
    
    public String goToPageCriarPessoa() {
        this.pessoa = null;
        return "criarPessoa";
    }
    
    public String goToPageEditarPessoa(Pessoa user) {
        this.pessoa = user;
        return "criarPessoaEquipe";
    }
    
     public String goToPageEditarPessoaArbitral(Pessoa user) {
        this.pessoa = user;
        return "criarPessoaArbitral";
    }
        
    /**
     * @return the usuarios
     */
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setPessoas(List<Pessoa> usuarios) {
        this.pessoas = usuarios;
    }
    
    public String getLabelPagina() {
        if (pessoa.getId() == null) {
            return "Criar novo usuário";
        }
        
        return "Edite o usuário";
    }
}
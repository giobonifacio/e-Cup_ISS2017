package com.controller;


import com.dao.UsuarioDAO;
import com.model.Usuario;
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
public class UsuarioMBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private List<Usuario> usuarios = new ArrayList<>();
    
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void onPageLoad(){
        carregaListaUsuarios();
        usuario = new Usuario();
    }
      
    public void onPageLoadCriarUsuario() {
        if (usuario == null) {
             usuario = new Usuario();
        }
    }
    
    public String criar()  {
        if (Utils.isNullOrEmpty(usuario.getUsuario()) || Utils.isNullOrEmpty(usuario.getSenha())) {
            return "erro";
        }
        
         try {
                if (usuario.getId() == null) {
                      usuarioDAO.salvar(usuario);
                    return "login";
                }
                  
                else
                    usuarioDAO.alterar(usuario);
                return goToPageControleUsuario();
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
    
    public void carregaListaUsuarios() {
        setUsuarios(usuarioDAO.listAll());
    }
    
    public String removeUsuario(Usuario user) {
        usuarioDAO.excluir(user);
        return goToPageControleUsuario();
    }
    
    public String goToPageCriarUsuario() {
        this.usuario = null;
        return "criarUsuario";
    }
    
    public String goToPageEditarUsuario(Usuario user) {
        this.usuario = user;
        return "criarUsuario";
    }
        
    public String goToPageControleUsuario() {
    return "usuarios";
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getLabelPagina() {
        if (usuario.getId() == null) {
            return "Criar novo usuário";
        }
        
        return "Edite o usuário";
    }
}

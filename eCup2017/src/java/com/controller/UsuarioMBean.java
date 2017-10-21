package com.controller;


import com.dao.UsuarioDAO;
import com.model.Usuario;
import com.util.Utils;
import java.io.Serializable;
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
    
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void onPageLoad(){
        usuario = new Usuario();
    }
      
    public String criar()  {
        if (Utils.isNullOrEmpty(usuario.getUsuario()) || Utils.isNullOrEmpty(usuario.getSenha())) {
            return "erro";
        }
        
         try {
                usuarioDAO.salvar(usuario);
                return "login";
            } catch (Exception e) {
                System.err.println("Não foi possível inserir usuário." + e);
            }
       return "erro";
    }
       
    public String goToPageCriarUsuario() {
        return "criarUsuario";
    }
    
    public String goToPageRemoverUsuario() {
        return "excluirUsuario";
    }
    
    public String goToPageEditarUsuario() {
        return "editarUsuario";
    }
    
    public String goToPageControleUsuario() {
    return "usuarios";
    }
}

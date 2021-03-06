package com.controller;


import com.dao.UsuarioDAO;
import com.model.Usuario;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import com.util.SessionUtils;
import com.util.Utils;
import javax.servlet.http.HttpSession;

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
public class LoginMBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String onPageLoad(){
       String usuarioLogado = SessionUtils.getUserName();

       if (!Utils.isNullOrEmpty(usuarioLogado)) 
           return "index";
       
        usuario = new Usuario();
        return null;
    }
      
    public String logar() {
        List<Usuario> listUsuarios = usuarioDAO.listAll();
        for (Usuario user : listUsuarios) {
            
            if (user.getSenha().equals(usuario.getSenha()) && user.getUsuario().equals(usuario.getUsuario())) { 
                HttpSession session = SessionUtils.getSession();
		session.setAttribute("username", usuario.getUsuario());
                return "index";
            }
        }
        return "erro";
    }
            
    public String deslogar() {
	HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
}
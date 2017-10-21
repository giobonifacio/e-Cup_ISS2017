
Save New Duplicate & Edit Just Text Twitter
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
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
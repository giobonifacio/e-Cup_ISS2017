
import bean.Usuario;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    private HibernateUtil hibernate;

    public void onPageLoad(){
        hibernate = new HibernateUtil();
        usuario = new Usuario();
    }
    
    public void setSenha(String senha) {
        this.usuario.setSenha(senha);
    }
   
    public void setUsuario(String usuario) {
        this.usuario.setUsuario(usuario);
    }
    
    public String getSenha() {
        return usuario.getSenha();
    }
   
    public String getUsuario() {
        return usuario.getUsuario();
    }
    
    public String logar() {
        List<Usuario> listUsuarios = hibernate.select();
        for (Usuario user : listUsuarios) {
            if (user.getSenha().equals(usuario.getSenha()) && user.getUsuario().equals(usuario.getUsuario()))
                return "loginRealizado";
        }
        return "naoAutenticado";
    }
            
}
